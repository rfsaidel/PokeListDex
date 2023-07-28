package com.saidel.pokelistdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.saidel.pokelistdex.iu.models.PokedexDetails
import com.saidel.pokelistdex.iu.screens.PokeListDexScreen

class PokeListDex : ComponentActivity() {

    private val pokeListDexViewModel: PokeListDexViewModel by viewModels()
    private var pokedexDetails: PokedexDetails? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeListDexScreen(
                pokeListDexViewModel, this
            )
        }
//        loadObserver()
        loadData()
    }

    private fun loadData() {
        pokeListDexViewModel.initApi()
        pokeListDexViewModel.loadPokeDex()
        pokeListDexViewModel.loadPkmData("151")
    }

//    private fun loadObserver() {
//        pokeListDexViewModel.state.observe(this) {
//            when (it) {
//                is PokeListDexStates.Success -> updateList(it)
//                is PokeListDexStates.Error -> showError(it)
//            }
//        }
//    }
//
//    private fun showError(state: PokeListDexStates.Error) {
//        Log.i("rfsaidel", "error > state ${state.errorMsg}")
//    }
//
//    private fun updateList(state: PokeListDexStates.Success) {
//        when (state.successMsg) {
//            is PokedexDetails -> {
//                pokedexDetails = state.successMsg
//                Log.i("rfsaidel", "success > state ${pokedexDetails?.count}")
//            }
//
//            is PkmDetails -> {
//                val pkmDetails = state.successMsg as PkmDetails?
//                Log.i("rfsaidel", "success > state ${pkmDetails?.name}")
//            }
//        }
//    }
}