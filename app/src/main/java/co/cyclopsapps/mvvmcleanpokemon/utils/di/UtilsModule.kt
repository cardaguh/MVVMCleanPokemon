package co.cyclopsapps.mvvmcleanpokemon.utils.di

import android.app.Application
import co.cyclopsapps.mvvmcleanpokemon.utils.preferences.IPreferences
import co.cyclopsapps.mvvmcleanpokemon.utils.preferences.Preferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

    @Singleton // Crea una sola instsanica
    @Provides // provee el valor
    fun providerPreferences(application: Application): IPreferences {
        return Preferences(application.baseContext)
    }
}