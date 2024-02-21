package com.pokemon.pokedexapp.domain

import com.pokemon.pokedexapp.data.PokeRepository
import com.pokemon.pokedexapp.domain.model.PokeItemDetails

class GetDetails {

    private val repository = PokeRepository()

    suspend fun fromPokemon(id: Int): PokeItemDetails? {
        return repository.getPokeDetails(id)
    }
}