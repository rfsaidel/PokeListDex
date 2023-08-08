package com.saidel.pokelistdex.iu.activities.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.saidel.pokelistdex.iu.screens.DetailsPkmScreen

class DetailsPkmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailsPkmScreen()
        }
    }
}