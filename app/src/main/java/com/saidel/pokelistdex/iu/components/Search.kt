package com.saidel.pokelistdex.iu.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchField(searchText: String, onSearchChange: (String) -> Unit) {
    Column {

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFDF5702),
                unfocusedBorderColor = Color(0xFFDF5702),
                cursorColor = Color(0xFFDF5702),
            ),
            shape = RoundedCornerShape(50),
            textStyle = TextStyle(
                color = Color(0xFFDF5702), fontSize = 16.sp
            ),
            placeholder = {
                Text("Qual Pokémon você procura?", color = Color(0xFFDF5702))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color(0xFFDF5702)
                )
            },
            label = {
                Text("Buscar", color = Color(0xFFDF5702))
            },
            value = searchText,
            onValueChange = { newValue ->
                onSearchChange(newValue)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            )
        )
    }
}

@Preview
@Composable
fun SearchFieldPreview() {
    SearchField("", onSearchChange = {})
}