package com.saidel.pokelistdex

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.saidel.pokelistdex.api.PkmListAPI
import com.saidel.pokelistdex.api.RetrofitConfig
import com.saidel.pokelistdex.models.PkmDetails
import com.saidel.pokelistdex.models.PkmList
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
        val pkmListCall: Call<PkmList?>? = apiService.getPkmList()
        pkmListCall?.enqueue(object : Callback<PkmList?> {
            override fun onResponse(call: Call<PkmList?>?, response: Response<PkmList?>?) {
                var pkmList: PkmList? = response?.body()
                state.value = PokeListDexStates.Success(pkmList)
            }

            override fun onFailure(call: Call<PkmList?>?, t: Throwable?) {
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