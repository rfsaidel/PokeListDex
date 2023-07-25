package com.saidel.pokelistdex.iu.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saidel.pokelistdex.iu.components.Item
import com.saidel.pokelistdex.models.Pkm

@OptIn(ExperimentalTextApi::class)
@Composable
fun PokeListDexScreen(pkmList: Array<Pkm>) {
    Surface(Modifier.background(Color.White)) {
        Column(
            modifier = Modifier
                .background(Color(0xFFFFB265))
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxHeight()
                .verticalScroll(rememberScrollState(0)),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box {
                Text(text = "PokeListDex", fontSize = 55.sp, color = Color(0xFFF67C37))
                Text(
                    text = "PokeListDex",
                    style = LocalTextStyle.current.merge(
                        TextStyle(
                            color = Color(0xFFDF5702),
                            fontSize = 55.sp,
                            drawStyle = Stroke(
                                width = 6f, join = StrokeJoin.Round,
                                pathEffect = PathEffect.cornerPathEffect(
                                    radius = 40f
                                )
                            )
                        )
                    )
                )
            }
            for (pkm in pkmList) {
                Item(pkm)
            }
            Spacer(Modifier)
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