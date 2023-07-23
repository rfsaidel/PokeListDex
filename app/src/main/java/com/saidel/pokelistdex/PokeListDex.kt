package com.saidel.pokelistdex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.saidel.pokelistdex.models.Pkm
import com.saidel.pokelistdex.models.PkmDetails
import com.saidel.pokelistdex.models.PkmList

class PokeListDex : ComponentActivity() {

    private val pokeListDexViewModel: PokeListDexViewModel by viewModels()
    private var pkmList: PkmList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(Modifier.background(Color.White)) {
                PokeList()
            }
        }
        loadObserver()
        loadData()
    }

    @Preview
    @Composable
    fun ItemPreview() {
        Item(Pkm().set("Pikachu"))
    }

    //@Preview(showSystemUi = true)
    @Composable
    fun PokeList() {
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

    @Composable
    fun Item(pkmData: Pkm) {
        Surface(
            shape = RoundedCornerShape(5.dp),
            shadowElevation = 5.dp,
            modifier = Modifier.height(70.dp)
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
                    Modifier
                        .width(configuration.screenWidthDp.dp-10.dp)
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
                Spacer(modifier = Modifier
                    .width(10.dp)
                    .fillMaxHeight()
                    .background(Color.Red))
                Text(LoremIpsum(10).values.first())
            }
        }
    }

    private fun loadData() {
        pokeListDexViewModel.loadPokeDex()
        pokeListDexViewModel.loadPkmData("151")
    }

    private fun loadObserver() {
        pokeListDexViewModel.initApi()
        pokeListDexViewModel.state.observe(this) {
            when (it) {
                is PokeListDexStates.Success -> updateList(it)
                is PokeListDexStates.Error -> showError(it)
            }
        }
    }

    private fun showError(state: PokeListDexStates.Error) {
        Log.i("rfsaidel", "error > state ${state.errorMsg}")
    }

    private fun updateList(state: PokeListDexStates.Success) {
        when (state.successMsg) {
            is PkmList -> {
                pkmList = state.successMsg
                Log.i("rfsaidel", "success > state ${pkmList?.count}")
            }

            is PkmDetails -> {
                val pkmDetails = state.successMsg as PkmDetails?
                Log.i("rfsaidel", "success > state ${pkmDetails?.name}")
            }
        }
    }
}