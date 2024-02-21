package com.pokemon.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.pokemon.pokedexapp.domain.model.PokeItem
import com.pokemon.pokedexapp.navigation.NavManager
import com.pokemon.pokedexapp.ui.theme.PokedexAPPTheme
import com.pokemon.pokedexapp.viewModel.PokemonViewModel
import com.pokemon.pokedexapp.views.HomeView


class MainActivity : ComponentActivity() {
    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexAPPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(viewModel)

                }
            }
        }
    }


    @Composable
    fun PokemonList(pokemonList: List<PokeItem>) {
        LazyColumn {
            items(pokemonList) { pokemon ->
                PokemonItem(pokemon)
            }
        }
    }

    @Composable
    fun PokemonItem(pokemon: PokeItem) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = pokemon.img,
                    contentDescription = "Pokemon",
                    modifier = Modifier.size(150.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = pokemon.name,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}