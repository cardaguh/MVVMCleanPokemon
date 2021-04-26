package co.cyclopsapps.mvvmcleanpokemon.services

import co.cyclopsapps.mvvmcleanpokemon.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Carlos Daniel Agudelo on 25/04/2021.
 */
interface WebService {
    @GET("pokedex.json")

    suspend fun getPokemons()
            : Response<PokemonResponse>
}