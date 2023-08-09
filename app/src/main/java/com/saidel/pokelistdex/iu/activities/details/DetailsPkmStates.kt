package com.saidel.pokelistdex.iu.activities.details

import com.saidel.pokelistdex.iu.models.PkmDetails

sealed class DetailsPkmStates {
    data class Success(val successMsg: PkmDetails?) : DetailsPkmStates()
    data class Error(val errorMsg: String) : DetailsPkmStates()
}