package com.saidel.pokelistdex.api

import com.saidel.pokelistdex.models.PkmDetails
import com.saidel.pokelistdex.models.PkmList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PkmListAPI {
    @GET("pokemon")
    fun getPkmList(): Call<PkmList?>?

    @GET("pokemon/{id}/")
    fun getPkmDetails(@Path("id") id: String): Call<PkmDetails?>?
}