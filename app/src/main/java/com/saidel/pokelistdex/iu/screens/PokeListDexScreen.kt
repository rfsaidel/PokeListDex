package com.saidel.pokelistdex.iu.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saidel.pokelistdex.iu.components.Item
import com.saidel.pokelistdex.models.Pkm

@Composable
fun PokeListDexScreen() {
    Surface(Modifier.background(Color.White)) {
        Column(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxHeight()
                .verticalScroll(rememberScrollState(0)),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "PokeListDex", fontSize = 40.sp, color = Color(0xff2a75bb))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Item(Pkm().set("Pikachu"))
            Spacer(Modifier)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PokeListDexScreenPreview() {
    PokeListDexScreen()
}