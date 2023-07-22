package com.saidel.pokelistdex.api

import com.saidel.pokelistdex.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitConfig() {

    private var retrofit: Retrofit? = null

    init {
        this.retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    fun getPkmListAPIService(): PkmListAPI? {
        return retrofit?.create(PkmListAPI::class.java)
    }
}