package com.saidel.pokelistdex.iu.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchField() {
    Column {
        var text by remember { mutableStateOf(value = "buscar") }
        OutlinedTextField(value = text, onValueChange = { newValue ->
            text = newValue
        })
    }
}

@Preview
@Composable
fun SearchFieldPreview() {
    SearchField()
}