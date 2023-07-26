package com.saidel.pokelistdex.iu.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.saidel.pokelistdex.R
import com.saidel.pokelistdex.iu.models.Pkm
import com.saidel.pokelistdex.utils.Constants.Companion.IMG_BASE_URL_SMALL


@Composable
fun Item(pkm: Pkm) {
    var name = pkm.name
    var number = pkm.getNumber()
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
                Modifier.width(configuration.screenWidthDp.dp - 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .offset(y = 5.dp, x = 5.dp)
                ) {
                    Canvas(
                        modifier = Modifier.size(60.dp)
                    ) {
                        val canvasHeight = size.height
                        drawCircle(
                            color = Color(0xFFEB6C1D), radius = canvasHeight
                        )
                    }
                    AsyncImage(
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                        model = IMG_BASE_URL_SMALL.plus(number).plus(".png"),
                        placeholder = painterResource(id = R.drawable.id_pkm_front_default)
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(name!!, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(1.dp))
                    Text("#${number!!.padStart(4,'0')}")
                }
            }
            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasHeight = size.height
                drawCircle(
                    color = Color(0xFFeb6834), radius = canvasHeight / 2
                )
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFeb6834), Color(0xFFEB8F34)
                            )
                        )
                    )
            ) {
                Text(LoremIpsum(10).values.first())
            }
        }
    }
}

@Preview
@Composable
private fun ItemPreview() {
    Item(Pkm().set("Pikachu"))
}
