package co.cyclopsapps.mvvmcleanpokemon.view.list

import androidx.lifecycle.ViewModel
import co.cyclopsapps.mvvmcleanpokemon.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ListModule {


    @ContributesAndroidInjector
    abstract fun bindPokemonListFragment(): PokemonListFragment

    @Binds
    @IntoMap
    @ViewModelKey(RecyclerPokemonViewModel::class)
    internal abstract fun bindRecyclerPokemonViewModel(viewModel: RecyclerPokemonViewModel): ViewModel
}