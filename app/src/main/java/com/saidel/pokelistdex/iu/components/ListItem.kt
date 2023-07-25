package com.saidel.pokelistdex.iu.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saidel.pokelistdex.R
import com.saidel.pokelistdex.models.Pkm

@Composable
fun Item(pkmData: Pkm) {
    Surface(
        shape = RoundedCornerShape(5.dp), shadowElevation = 5.dp, modifier = Modifier.height(70.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState(0))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFEB8F34), Color(0xFFEB6C1D)
                        )
                    )
                )
        ) {
            val configuration = LocalConfiguration.current
            Row(
                Modifier.width(configuration.screenWidthDp.dp - 25.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.id_pkm_front_default),
                    contentDescription = null,
                    Modifier
                        .size(60.dp)
                        .offset(y = 5.dp, x = 5.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(2.dp, color = Color(0xFFeb6834)), shape = CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(pkmData.name!!, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(1.dp))
                    Text("Hello World 2")
                }
            }
            Box {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = Color(0xFFeb6834),
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                        .offset(x = -15.dp)
                        .border(
                            BorderStroke(1.dp, color = Color(0xFFF05011)), shape = CircleShape
                        )
                ) {}
                Spacer(
                    modifier = Modifier
                        .width(5.dp)
                        .fillMaxHeight()
                        .background(Color(0xFFEB6834))
                        .border(1.dp, color = Color(0xFFF05011))
                )
            }

            Text(LoremIpsum(10).values.first())
        }
    }
}

@Preview
@Composable
private fun ItemPreview() {
    Item(Pkm().set("Pikachu"))
}
