package co.cyclopsapps.mvvmcleanpokemon.viewmodels

import android.app.Application
import androidx.lifecycle.*
import co.cyclopsapps.mvvmcleanpokemon.model.PokemonDataModel
import co.cyclopsapps.mvvmcleanpokemon.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Created by Carlos Daniel Agudelo on 25/04/2021.
 */
class RecyclerPokemonViewModel(app: Application): AndroidViewModel(app), CoroutineScope {

    private val _itemSelected = MutableLiveData<PokemonDataModel>()
    val itemSelected: LiveData<PokemonDataModel> = _itemSelected

    private val _listState = MutableLiveData<MutableList<PokemonDataModel>>()
    val listState: LiveData<MutableList<PokemonDataModel>> = _listState

    private val repository = PokemonRepository()
    lateinit var observerOnCategorySelected: Observer<PokemonDataModel>

    private val viewModelJob = Job()
    override val coroutineContext: CoroutineContext
    get() = viewModelJob + Dispatchers.Default

    init {
        initObserver()
    }

    private fun initObserver() {
        observerOnCategorySelected = Observer { value ->
            value.let {
                _itemSelected.value = it
            }
        }
    }

    fun clearSelection() {
        _itemSelected.value = null
    }

    fun fetchPokemonData() {
        viewModelScope.launch {
            val response = repository.getPokemon()
            response?.body()?.pokemon?.let { list ->
                _listState.value = list
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}