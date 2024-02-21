package com.pokemon.pokedexapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import com.pokemon.pokedexapp.viewModel.PokemonViewModel
import com.pokemon.pokedexapp.views.DetailView
import com.pokemon.pokedexapp.views.HomeView

@Composable
fun NavManager(viewModel: PokemonViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {

        composable("Home") {
            HomeView(viewModel, navController)
        }

        composable(
            "DetailView/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("id") ?: 0
            DetailView(viewModel, navController, id)
        }

    }
}
