package com.saidel.pokelistdex

import com.saidel.pokelistdex.models.PkmList

sealed class PokeListDexStates {
    data class Success(val successMsg: Any?) : PokeListDexStates()
    data class Error(val errorMsg: String) : PokeListDexStates()
}
