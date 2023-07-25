package com.saidel.pokelistdex.iu.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.saidel.pokelistdex.R

@OptIn(ExperimentalTextApi::class)
@Composable
fun Title() {
    Box {
        Text(text = stringResource(R.string.app_name), fontSize = 55.sp, color = Color(0xFFF67C37))
        Text(
            text = stringResource(R.string.app_name), style = LocalTextStyle.current.merge(
                TextStyle(
                    color = Color(0xFFDF5702), fontSize = 55.sp, drawStyle = Stroke(
                        width = 6f,
                        join = StrokeJoin.Round,
                        pathEffect = PathEffect.cornerPathEffect(
                            radius = 40f
                        )
                    )
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    Title()
}
