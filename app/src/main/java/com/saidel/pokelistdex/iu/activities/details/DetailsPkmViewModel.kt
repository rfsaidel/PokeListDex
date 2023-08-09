package com.saidel.pokelistdex.iu.activities.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.saidel.pokelistdex.api.PkmListAPI
import com.saidel.pokelistdex.iu.models.PkmDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsPkmViewModel(application: Application) : AndroidViewModel(application) {

    val state = MutableLiveData<DetailsPkmStates>()
    lateinit var apiService: PkmListAPI

    fun loadPkmData(id: String) {
        val pkmListCall: Call<PkmDetails?>? = apiService.getPkmDetails(id)
        pkmListCall?.enqueue(object : Callback<PkmDetails?> {
            override fun onResponse(call: Call<PkmDetails?>, response: Response<PkmDetails?>) {
                val pkmDetails: PkmDetails? = response.body()
                state.value = DetailsPkmStates.Success(pkmDetails)
            }

            override fun onFailure(call: Call<PkmDetails?>, t: Throwable) {
                state.value = DetailsPkmStates.Error(t.toString())
            }
        })
    }
}