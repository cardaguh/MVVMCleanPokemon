package co.cyclopsapps.mvvmcleanpokemon.view

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}