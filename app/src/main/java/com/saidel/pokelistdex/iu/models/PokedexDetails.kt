package com.saidel.pokelistdex.iu.models

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
    var url: String? = "https://pokeapi.co/api/v2/pokemon/123/"
    @DrawableRes
    var img: Int = 0

    fun set(name: String): Pkm {
        this.name = name
        return this
    }

    fun getNumber(): String? {
        return this.url!!.split('/').dropLast(1).last()
    }
}