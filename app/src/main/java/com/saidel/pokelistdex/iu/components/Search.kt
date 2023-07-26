package com.saidel.pokelistdex.iu.components

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saidel.pokelistdex.PokeListDexViewModel

@Composable
fun SearchField(pokeListDexViewModel: PokeListDexViewModel) {
    Column {
        var text by remember { mutableStateOf("") }
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
            value = text,
            onValueChange = { newValue ->
                text = newValue
                pokeListDexViewModel.setSearch(text)
            })
    }
}

@Preview
@Composable
fun SearchFieldPreview() {
    SearchField(PokeListDexViewModel(Application()))
}