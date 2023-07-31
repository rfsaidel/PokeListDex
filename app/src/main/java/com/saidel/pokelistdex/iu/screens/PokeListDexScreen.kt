package com.saidel.pokelistdex.iu.screens

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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
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
        var pkmList by remember { mutableStateOf<Array<Pkm>>(arrayOf()) }
        var filteredPkmList by remember { mutableStateOf<List<Pkm>>(listOf()) }
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
                var searchText by remember { mutableStateOf("") }
                SearchField(
                    searchText,
                    onSearchChange = { newSearchValue ->
                        searchText = newSearchValue

                        filteredPkmList = pkmList.filter { pkm ->
                            pkm.name!!.contains(newSearchValue, ignoreCase = true) ||
                                    pkm.getNumber()!!.contains(newSearchValue, ignoreCase = true)
                        }
                    },
                )
            }

            pokeListDexViewModel.state.observe(owner!!) {
                when (it) {
                    is PokeListDexStates.Success -> {
                        when (it.successMsg) {
                            is PokedexDetails -> {
                                pkmList = it.successMsg.results!!
                                filteredPkmList = pkmList.toList()
                            }
                        }
                    }

                    is PokeListDexStates.Error -> null
                }
            }

            items(filteredPkmList.size) { pkmIndex ->
                Item(filteredPkmList.get((pkmIndex)))
            }

            // FOR TESTING
//            var pkm = Pkm().set("testestes")
//            for (i in 1..151) {
//                item {
//                    Item(pkm)
//                }
//            }
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