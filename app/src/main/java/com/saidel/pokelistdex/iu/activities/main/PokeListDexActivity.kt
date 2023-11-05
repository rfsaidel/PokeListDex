package com.saidel.pokelistdex.iu.activities.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import com.saidel.pokelistdex.iu.models.Pkm
import com.saidel.pokelistdex.iu.screens.PokeListDexScreen
import com.saidel.pokelistdex.iu.screens.PokeListDexScreenIuState

class PokeListDexActivity : ComponentActivity() {

    private val pokeListDexViewModel: PokeListDexViewModel by viewModels()
    private var pkmList = mutableStateListOf<Pkm>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        var state = PokeListDexScreenIuState(pkmList)
                        PokeListDexScreen(
                            state
                        )
                    }
                }
            }
        }
        loadObserver()
        loadData()
    }

    private fun loadData() {
        pokeListDexViewModel.initApi()
        pokeListDexViewModel.loadPokeDex()
        //pokeListDexViewModel.loadPkmData("151")
    }

    private fun loadObserver() {
        pokeListDexViewModel.state.observe(this) {
            when (it) {
                is PokeListDexStates.Success -> updateList(it)
                is PokeListDexStates.Error -> showError(it)
            }
        }
    }

    private fun showError(state: PokeListDexStates.Error) {
        Log.i("rfsaidel", "error >> state ${state.errorMsg}")
    }

    private fun updateList(state: PokeListDexStates.Success) {
        pkmList.addAll(state.successMsg?.results!!.toMutableList())
        Log.i("rfsaidel", "success >> state ${pkmList.count()}")
    }
}