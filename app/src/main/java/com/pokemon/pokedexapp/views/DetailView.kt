package com.pokemon.pokedexapp.views

import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.anluisa.gamesretrofit.util.Constants.Companion.CUSTOM_BLACK
import com.pokemon.pokedexapp.viewModel.PokemonViewModel

@Composable
fun DetailView(viewModel: PokemonViewModel, navController: NavController, id:Int){
    LaunchedEffect(Unit){
        viewModel.getPokeById(id)
    }
    Scaffold(
        topBar= {
            MainTopBar(title = viewModel.state.name, showBackButton = true) {
                navController.popBackStack()
            }
        }
    ){
        //ContenDetailView(pad = it, viewModel = viewModel)
    }

}

/* Hay q añadir un metodo para pillar la imagen y arreglar esto!
@Composable
fun ContenDetailView(pad: PaddingValues, viewModel: PokemonViewModel){
    val state= viewModel.state
    Column(modifier= Modifier
        .padding(pad)
        .background(Color(CUSTOM_BLACK))
    ) {
        MainImage(image=state.background_image)
        Spacer(modifier=Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 5.dp)
        ){
            MetaWebsite(state.)
        }
    }
}
*/