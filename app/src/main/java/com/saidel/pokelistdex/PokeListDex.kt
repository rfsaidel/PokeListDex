package com.saidel.pokelistdex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.saidel.pokelistdex.iu.screens.PokeListDexScreen
import com.saidel.pokelistdex.models.Pkm
import com.saidel.pokelistdex.models.PkmDetails
import com.saidel.pokelistdex.models.PokedexDetails

class PokeListDex : ComponentActivity() {

    private val pokeListDexViewModel: PokeListDexViewModel by viewModels()
    private var pokedexDetails: PokedexDetails? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeListDexScreen(
                arrayOf(
                    Pkm().set("Pikachu"), Pkm().set("Chamander"), Pkm().set("Bulbasaur")
                )
                //pokedexDetails?.results
            )
        }
        loadObserver()
        loadData()
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
            is PokedexDetails -> {
                pokedexDetails = state.successMsg
                Log.i("rfsaidel", "success > state ${pokedexDetails?.count}")
            }

            is PkmDetails -> {
                val pkmDetails = state.successMsg as PkmDetails?
                Log.i("rfsaidel", "success > state ${pkmDetails?.name}")
            }
        }
    }
}