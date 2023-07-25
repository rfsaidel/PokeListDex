package com.saidel.pokelistdex.iu.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saidel.pokelistdex.iu.components.Item
import com.saidel.pokelistdex.iu.components.SearchField
import com.saidel.pokelistdex.iu.components.Title
import com.saidel.pokelistdex.models.Pkm

@Composable
fun PokeListDexScreen(pkmList: Array<Pkm>?) {

    Surface(Modifier.background(Color.White)) {
        LazyColumn(
            modifier = Modifier
                .background(Color(0xFFFFB265))
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(vertical = 10.dp)
        ) {
            item {
                SearchField()
            }
            item {
                Title()
            }
            items(pkmList!!.size) { pkmIndex ->
                Item(pkmList.get(pkmIndex))
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
        )
    )
}