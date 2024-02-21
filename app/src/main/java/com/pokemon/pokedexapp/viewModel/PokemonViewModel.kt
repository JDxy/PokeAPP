package com.pokemon.pokedexapp.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokemon.pokedexapp.domain.GetDetails
import com.pokemon.pokedexapp.domain.GetPokemons
import com.pokemon.pokedexapp.domain.model.PokeItem
import com.pokemon.pokedexapp.state.PokemonState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel : ViewModel() {

    var state by mutableStateOf(PokemonState())

    private val getPokemons = GetPokemons()

    private val _pokemonList = MutableLiveData<List<PokeItem>>()
    val pokemonList: LiveData<List<PokeItem>> = _pokemonList

    // Nuevo estado observable para la lista de Pokémon
    private val _pokemonListState: MutableState<List<PokeItem>> = mutableStateOf(emptyList())
    val pokemonListState: MutableState<List<PokeItem>> = _pokemonListState

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


     fun getPokeById(id: Int){
         viewModelScope.launch{
             withContext(Dispatchers.IO){
                 val result= GetDetails().fromPokemon(id)
                 state=state.copy(
                     name=result?.name ?: "",
                     img= result?.img ?:"",
                     hp = result?.hp ?: 0,
                     attack = result?.attack ?: 0,
                     defense = result?.defense ?: 0,
                     specialAttack = result?.specialAttack ?: 0,
                     specialDefense = result?.specialDefense ?: 0,
                     speed = result?.speed ?: 0,
                     types = result?.types ?: listOf(),
                     weight = result?.weight ?: 0.0,
                     height = result?.height ?: 0.0
                 )
             }
         }
     }
}
