package com.saidel.pokelistdex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saidel.pokelistdex.models.PkmDetails
import com.saidel.pokelistdex.models.PkmList

class PokeListDex : ComponentActivity() {

    private val pokeListDexViewModel: PokeListDexViewModel by viewModels()
    private var pkmList: PkmList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                items(20) { index ->
                    Text(
                        text = "Sample: Item $index",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                }
            }
        }
        loadObserver()
        loadData()

    }

    @Preview
    @Composable
    private fun loadView() {
        Text("Hello World")
    }

    private fun loadData() {
        pokeListDexViewModel.loadPokeDex()
        pokeListDexViewModel.loadPkmData("151")
    }

    private fun loadObserver() {
        pokeListDexViewModel.initApi()
        pokeListDexViewModel.state.observe(this) {
            when (it) {
                is PokeListDexStates.Success -> updateList(it)
                is PokeListDexStates.Error -> showError(it)
            }
        }
    }

    private fun showError(state: PokeListDexStates.Error) {
        Log.i("rfsaidel", "error > state ${state.errorMsg}")
    }

    private fun updateList(state: PokeListDexStates.Success) {
        when (state.successMsg) {
            is PkmList -> {
                pkmList = state.successMsg as PkmList?
                Log.i("rfsaidel", "success > state ${pkmList?.count}")
            }

            is PkmDetails -> {
                val pkmDetails = state.successMsg as PkmDetails?
                Log.i("rfsaidel", "success > state ${pkmDetails?.name}")
            }
        }
    }
}