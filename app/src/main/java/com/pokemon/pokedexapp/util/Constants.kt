package com.anluisa.gamesretrofit.util

class Constants {
    companion object{
        const val BASE_URL = "https://pokeapi.co/api/v2/"
        const val ENDPOINT="pokemon?limit=10"
        const val ENDPOINT2="pokemon/{id}"
        const val CUSTOM_BLACK=0xFF2B2626
    }
}
//Ejemplos de endpoints:
//Recuperamos todos los juegos
//https://api.rawg.io/api/games?key=623db30bcbf14c5ab621f33d521fdc54
//recuperamos un juego con un cierto ID
//https://api.rawg.io/api/games/1123?key=623db30bcbf14c5ab621f33d521fdc54