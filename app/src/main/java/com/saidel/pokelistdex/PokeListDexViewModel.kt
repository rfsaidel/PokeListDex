package com.saidel.pokelistdex

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.saidel.pokelistdex.api.PkmListAPI
import com.saidel.pokelistdex.api.RetrofitConfig
import com.saidel.pokelistdex.iu.models.PkmDetails
import com.saidel.pokelistdex.iu.models.PokedexDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeListDexViewModel(application: Application) : AndroidViewModel(application) {

    val state = MutableLiveData<PokeListDexStates>()
    lateinit var apiService: PkmListAPI

    fun initApi() {
        apiService = RetrofitConfig().getPkmListAPIService()!!
    }

    fun loadPokeDex() {
        val pokedexDetailsCall: Call<PokedexDetails?>? = apiService.getPkmList()
        pokedexDetailsCall?.enqueue(object : Callback<PokedexDetails?> {
            override fun onResponse(
                call: Call<PokedexDetails?>?, response: Response<PokedexDetails?>?
            ) {
                var pokedexDetails: PokedexDetails? = response?.body()
                state.value = PokeListDexStates.Success(pokedexDetails)
            }

            override fun onFailure(call: Call<PokedexDetails?>?, t: Throwable?) {
                state.value = PokeListDexStates.Error(t.toString())
            }
        })
    }

    fun loadPkmData(id: String) {
        val pkmListCall: Call<PkmDetails?>? = apiService.getPkmDetails(id)
        pkmListCall?.enqueue(object : Callback<PkmDetails?> {
            override fun onResponse(call: Call<PkmDetails?>?, response: Response<PkmDetails?>?) {
                var pkmDetails: PkmDetails? = response?.body()
                state.value = PokeListDexStates.Success(pkmDetails)
            }

            override fun onFailure(call: Call<PkmDetails?>?, t: Throwable?) {
                state.value = PokeListDexStates.Error(t.toString())
            }
        })
    }
}