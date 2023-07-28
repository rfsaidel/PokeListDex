package com.saidel.pokelistdex.iu.screens

import android.util.Log
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import com.saidel.pokelistdex.PokeListDexComposeStates
import com.saidel.pokelistdex.PokeListDexStates
import com.saidel.pokelistdex.PokeListDexViewModel
import com.saidel.pokelistdex.iu.components.Item
import com.saidel.pokelistdex.iu.components.SearchField
import com.saidel.pokelistdex.iu.components.Title
import com.saidel.pokelistdex.iu.models.Pkm
import com.saidel.pokelistdex.iu.models.PokedexDetails

@Composable
fun PokeListDexScreen(
    pokeListDexViewModel: PokeListDexViewModel, owner: LifecycleOwner?
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

            var pkmList by mutableStateOf<Array<Pkm>?>(arrayOf())
            pokeListDexViewModel.state.observe(owner!!) {
                when (it) {
                    is PokeListDexStates.Success -> {
                        when (it.successMsg) {
                            is PokedexDetails -> {
                                pkmList = it.successMsg.results
                                for (pkm in pkmList!!) {
                                    Log.i("rfsaidel", "FORRRR")
                                    item {
                                        Item(pkm)
                                    }
                                }
                            }
                        }
                    }
                    is PokeListDexStates.Error -> null
                }
            }

            var searchText by mutableStateOf("")
            owner.let {
                pokeListDexViewModel.composeState.observe(it) {
                    when (it) {
                        is PokeListDexComposeStates.Search -> {
                            searchText = it.value
                        }
                    }
                }
            }

            if (searchText.isBlank()) {
                Log.i("rfsaidel", "not blank")
            } else {
                Log.i("rfsaidel", "blank")
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun PokeListDexScreenPreview() {
//    PokeListDexScreen(
//        arrayOf(
//            Pkm().set("Pikachu"), Pkm().set("Chamander"), Pkm().set("Bulbasaur")
//        ), PokeListDexViewModel(Application()), null
//    )
//}