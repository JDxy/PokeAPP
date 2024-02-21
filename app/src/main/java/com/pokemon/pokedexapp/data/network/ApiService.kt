package com.pokemon.pokedexapp.data.network

import com.pokemon.pokedexapp.core.RetrofitHelper
import com.pokemon.pokedexapp.data.model.PokeModel
import com.pokemon.pokedexapp.data.model.PokeModelDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemons(): List<PokeModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getListPokemon()
            response.body()?.pokemons ?: emptyList()
        }
    }

    suspend fun getDetailsPokemon(id: Int): PokeModelDetails?{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getDetailsPokemon(id)
            response.body()
        }
    }


}