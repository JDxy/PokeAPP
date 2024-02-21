package com.pokemon.pokedexapp.data

import com.pokemon.pokedexapp.data.network.ApiService
import com.pokemon.pokedexapp.domain.model.PokeItem
import com.pokemon.pokedexapp.domain.model.PokeItemDetails
import com.pokemon.pokedexapp.domain.model.toDomain

class PokeRepository {
    private val api = ApiService()
    suspend fun getAllPokemons(): List<PokeItem> {
        val response = api.getPokemons()
        return response.map { it.toDomain() }
    }
    suspend fun getPokeDetails(id: Int): PokeItemDetails? {
        val response = api.getDetailsPokemon(id)
        return response?.toDomain()
    }
}