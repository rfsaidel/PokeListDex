package com.saidel.pokelistdex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saidel.pokelistdex.iu.components.Item
import com.saidel.pokelistdex.models.Pkm
import com.saidel.pokelistdex.models.PkmDetails
import com.saidel.pokelistdex.models.PkmList

class PokeListDex : ComponentActivity() {

    private val pokeListDexViewModel: PokeListDexViewModel by viewModels()
    private var pkmList: PkmList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
        loadObserver()
        //loadData()
    }

    @Composable
    fun App() {
        Surface(Modifier.background(Color.White)) {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState(0)),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "PokeListDex", fontSize = 40.sp, color = Color(0xff2a75bb))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Item(Pkm().set("Pikachu"))
                Spacer(Modifier)
            }
        }
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
                pkmList = state.successMsg
                Log.i("rfsaidel", "success > state ${pkmList?.count}")
            }

            is PkmDetails -> {
                val pkmDetails = state.successMsg as PkmDetails?
                Log.i("rfsaidel", "success > state ${pkmDetails?.name}")
            }
        }
    }
}