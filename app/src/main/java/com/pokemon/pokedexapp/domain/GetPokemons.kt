package com.pokemon.pokedexapp.domain

import com.pokemon.pokedexapp.data.PokeRepository
import com.pokemon.pokedexapp.domain.model.PokeItem

class GetPokemons {

    private val repository = PokeRepository()

    suspend fun listAll(): List<PokeItem> {
        return repository.getAllPokemons()
    }
}