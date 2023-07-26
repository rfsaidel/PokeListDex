package com.saidel.pokelistdex.iu.screens

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.saidel.pokelistdex.PokeListDexComposeStates
import com.saidel.pokelistdex.PokeListDexViewModel
import com.saidel.pokelistdex.iu.components.Item
import com.saidel.pokelistdex.iu.components.SearchField
import com.saidel.pokelistdex.iu.components.Title
import com.saidel.pokelistdex.iu.models.Pkm

@Composable
fun PokeListDexScreen(
    pkmList: Array<Pkm>?, pokeListDexViewModel: PokeListDexViewModel, owner: LifecycleOwner?
) {

    Surface(Modifier.background(Color.White)) {
        LazyColumn(
            modifier = Modifier
                .background(Color(0xFFFFB265))
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            item {
                Title()
            }
            item {
                SearchField(pokeListDexViewModel)
            }
            items(pkmList!!.size) { pkmIndex ->
                var searchText by remember { mutableStateOf("") }

                owner.let {
                    pokeListDexViewModel.composeState.observe(it!!) {
                        when (it) {
                            is PokeListDexComposeStates.Search -> {
                                searchText = it.value
                            }
                        }
                    }
                }

                if (searchText.isBlank()) Item(pkmList.get(pkmIndex))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PokeListDexScreenPreview() {
    PokeListDexScreen(
        arrayOf(
            Pkm().set("Pikachu"), Pkm().set("Chamander"), Pkm().set("Bulbasaur")
        ), PokeListDexViewModel(Application()), null
    )
}