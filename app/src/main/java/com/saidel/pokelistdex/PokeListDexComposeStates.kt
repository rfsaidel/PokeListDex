package com.saidel.pokelistdex

sealed class PokeListDexComposeStates {
    data class Search(val value: String) : PokeListDexComposeStates()
}