package com.saidel.pokelistdex.iu.activities.main

import com.saidel.pokelistdex.iu.models.PokedexDetails

sealed class PokeListDexStates {
    data class Success(val successMsg: PokedexDetails?) : PokeListDexStates()
    data class Error(val errorMsg: String) : PokeListDexStates()
}