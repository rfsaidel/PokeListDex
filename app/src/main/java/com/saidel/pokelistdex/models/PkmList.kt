package com.saidel.pokelistdex.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonIncludeProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class PkmList {
    var count: String? = null
    var next: String? = null
    var previous: String? = null
    var results: Array<Pkm>? = null
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Pkm {
    var name: String? = null
    var url: String? = null
}