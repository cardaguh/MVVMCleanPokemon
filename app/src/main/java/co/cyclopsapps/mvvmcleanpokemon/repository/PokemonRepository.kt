package co.cyclopsapps.mvvmcleanpokemon.repository

import co.cyclopsapps.mvvmcleanpokemon.services.RetrofitClient
import co.cyclopsapps.mvvmcleanpokemon.services.WebService

/**
 * Created by Carlos Daniel Agudelo on 25/04/2021.
 */
class PokemonRepository {
    private var apiService: WebService? = null

    init {
        apiService = RetrofitClient.getClient?.create(WebService::class.java)
    }

    suspend fun getPokemon() = apiService?.getPokemons()
}