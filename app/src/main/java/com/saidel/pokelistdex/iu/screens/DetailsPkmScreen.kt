package com.saidel.pokelistdex.iu.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.saidel.pokelistdex.R
import com.saidel.pokelistdex.utils.Constants

@Composable
fun DetailsPkmScreen() {
    MaterialTheme {
        Surface {
            Row {
                AsyncImage(
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape),
                    model = Constants.IMG_BASE_URL_BIG.plus(6).plus(".png"),
                    placeholder = painterResource(id = R.drawable.pokebola_3d)
                )
                Column {
                    Text("#0006")
                    Text("Charizard")
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    DetailsPkmScreen()
}