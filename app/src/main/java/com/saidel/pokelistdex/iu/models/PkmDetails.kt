package com.saidel.pokelistdex.iu.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonIncludeProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class PkmDetails {

    var name: String? = null
    var id: String? = null
    var height: String? = null
    var weight: String? = null
    var base_experience: String? = null
    var sprites: Sprites? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Sprites {
    var front_default: String? = null
    var front_shiny: String? = null
}