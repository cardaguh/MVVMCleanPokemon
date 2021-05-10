package co.cyclopsapps.mvvmcleanpokemon.di

import android.app.Application
import co.cyclopsapps.mvvmcleanpokemon.base.App
import co.cyclopsapps.mvvmcleanpokemon.base.ViewModelProviderModule
import co.cyclopsapps.mvvmcleanpokemon.utils.di.UtilsModule
import co.cyclopsapps.mvvmcleanpokemon.view.MainModule
import co.cyclopsapps.mvvmcleanpokemon.view.di.DetailModule
import co.cyclopsapps.mvvmcleanpokemon.view.list.ListModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, // De cajon copy paste
        ViewModelProviderModule::class,
        UtilsModule::class,
        MainModule::class,
        ListModule::class,
        DetailModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App) // lo unico que cambia es este por
    // tu nombre de class que extiende de Application
}