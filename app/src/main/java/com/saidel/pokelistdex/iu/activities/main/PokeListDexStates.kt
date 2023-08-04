package com.saidel.pokelistdex.iu.activities.main

sealed class PokeListDexStates {
    data class Success(val successMsg: Any?) : PokeListDexStates()
    data class Error(val errorMsg: String) : PokeListDexStates()
}
