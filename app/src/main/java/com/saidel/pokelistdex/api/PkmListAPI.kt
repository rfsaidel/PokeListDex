package com.saidel.pokelistdex.api

import com.saidel.pokelistdex.iu.models.PkmDetails
import com.saidel.pokelistdex.iu.models.PokedexDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PkmListAPI {
    @GET("pokemon/?offset=0&limit=151&")
    fun getPkmList(): Call<PokedexDetails?>?

    @GET("pokemon/{id}/")
    fun getPkmDetails(@Path("id") id: String): Call<PkmDetails?>?
}