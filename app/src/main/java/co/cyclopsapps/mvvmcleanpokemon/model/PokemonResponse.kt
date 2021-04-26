package co.cyclopsapps.mvvmcleanpokemon.model

/**
 * Created by Carlos Daniel Agudelo on 25/04/2021.
 */
data class PokemonResponse(
    //val info: Pager,
    val pokemon: MutableList<PokemonDataModel> = mutableListOf()
)

data class Pager(
    val count: Long,
    val pages: Int,
    val next: String,
    val prev: String
)


data class PokemonDataModel(
    val id: Long,
    val name: String = "",
    val img: String
)