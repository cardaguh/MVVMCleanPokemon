package co.cyclopsapps.mvvmcleanpokemon.view.di

import co.cyclopsapps.mvvmcleanpokemon.view.detail.PokemonDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailModule {

    @ContributesAndroidInjector
    abstract fun bindPokemonDetailFragment(): PokemonDetailFragment


}