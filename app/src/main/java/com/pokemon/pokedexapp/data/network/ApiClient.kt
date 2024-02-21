package com.pokemon.pokedexapp.data.network

import com.anluisa.gamesretrofit.util.Constants.Companion.ENDPOINT
import com.anluisa.gamesretrofit.util.Constants.Companion.ENDPOINT2
import com.pokemon.pokedexapp.data.model.PokeModelDetails
import com.pokemon.pokedexapp.data.model.ResultApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET(ENDPOINT)
    suspend fun getListPokemon(): Response<ResultApi>

    @GET(ENDPOINT2)
    suspend fun getDetailsPokemon(@Path("id") id: Int): Response<PokeModelDetails>
}

