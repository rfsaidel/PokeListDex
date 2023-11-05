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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saidel.pokelistdex.iu.components.Item
import com.saidel.pokelistdex.iu.components.SearchField
import com.saidel.pokelistdex.iu.components.Title
import com.saidel.pokelistdex.iu.models.Pkm

class PokeListDexScreenIuState(var pkmList: MutableList<Pkm>) {
    var filteredPkmList by mutableStateOf<List<Pkm>>(listOf())

    fun searchPkm(newSearchValue: String){
        filteredPkmList = pkmList.filter { pkm ->
            pkm.name!!.contains(
                newSearchValue, ignoreCase = true
            ) || pkm.getNumber()!!.contains(newSearchValue, ignoreCase = true)
        }
    }

    var onSearchChange: (String) -> Unit = {searchText ->
        searchPkm(searchText)
    }
}

@Composable
fun PokeListDexScreen(
    state: PokeListDexScreenIuState
) {
    Surface(Modifier.background(Color.White)) {
        state.filteredPkmList = state.pkmList
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
                        state.onSearchChange(newSearchValue)
                    },
                )
            }

            items(state.filteredPkmList.size) { pkmIndex ->
                Item(state.filteredPkmList.get((pkmIndex)))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PokeListDexScreenPreview() {
    PokeListDexScreen(
        state = PokeListDexScreenIuState(
            pkmList = listOf(
                Pkm().set("Pikachu"), Pkm().set("Chamander"), Pkm().set("Bulbasaur")
            ).toMutableList()
        )
    )
}