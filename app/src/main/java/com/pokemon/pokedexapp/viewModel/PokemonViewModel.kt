package com.pokemon.pokedexapp.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokemon.pokedexapp.domain.GetPokemons
import com.pokemon.pokedexapp.domain.model.PokeItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class PokemonViewModel : ViewModel() {

    private val getPokemons = GetPokemons()

    private val _pokemonList = MutableLiveData<List<PokeItem>>()
    val pokemonList: LiveData<List<PokeItem>> = _pokemonList

    // Nuevo estado observable para la lista de Pokémon
    private val _pokemonListState: MutableState<List<PokeItem>> = mutableStateOf(emptyList())
    val pokemonListState: MutableState<List<PokeItem>> = _pokemonListState

    // Método público para observar la lista de Pokémon
    fun observePokemonList(observer: (List<PokeItem>) -> Unit) {
        pokemonList.observeForever { pokemonList ->
            observer(pokemonList)
        }
    }
    private fun fetchPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val pokemons = getPokemons.listAll()
                _pokemonList.postValue(pokemons)
                _pokemonListState.value = pokemons // Actualizamos el nuevo estado observable
            } catch (e: Exception) {
                // Manejar el error, por ejemplo, publicarlo en LiveData para que la actividad pueda manejarlo
            }

        }
    }
    init {
        fetchPokemons()
    }

}
