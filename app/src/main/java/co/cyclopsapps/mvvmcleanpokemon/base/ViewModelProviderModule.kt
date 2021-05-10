package co.cyclopsapps.mvvmcleanpokemon.base

import androidx.lifecycle.ViewModelProvider
import co.cyclopsapps.mvvmcleanpokemon.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderModule {
    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}