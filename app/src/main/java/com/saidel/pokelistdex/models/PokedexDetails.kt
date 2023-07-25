package com.saidel.pokelistdex.models

import androidx.annotation.DrawableRes
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class PokedexDetails {
    var count: String? = null
    var next: String? = null
    var previous: String? = null
    var results: Array<Pkm>? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Pkm {
    var name: String? = null
    var url: String? = null
    @DrawableRes
    var img: Int = 0

    fun set(name: String): Pkm {
        this.name = name
        return this
    }
}