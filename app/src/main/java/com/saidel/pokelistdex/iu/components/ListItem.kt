package com.saidel.pokelistdex.iu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ListItem {
    @Preview(showBackground = true)
    @Composable
    private fun loadView() {
        Column(
            Modifier
                .height(100.dp)
                .width(200.dp)
                .background(Color.Blue)
        ) {
            Text("Hello World 1")
            Text("Hello World 2")
        }
    }

}