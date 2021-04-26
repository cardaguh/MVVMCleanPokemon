package co.cyclopsapps.mvvmcleanpokemon.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.cyclopsapps.mvvmcleanpokemon.R
import co.cyclopsapps.mvvmcleanpokemon.databinding.FragmentPokemonListBinding
import co.cyclopsapps.mvvmcleanpokemon.model.PokemonDataModel
import co.cyclopsapps.mvvmcleanpokemon.view.adapter.ItemsAdapter
import co.cyclopsapps.mvvmcleanpokemon.viewmodels.RecyclerPokemonViewModel

class PokemonListFragment : Fragment(), ClickListener {
    lateinit var viewModel: RecyclerPokemonViewModel
    lateinit var binding: FragmentPokemonListBinding
    private var mAdapter: ItemsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            activity?.let { ViewModelProvider(it).get(RecyclerPokemonViewModel::class.java) }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon_list, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerview inits
        mAdapter = ItemsAdapter(this)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = mAdapter


        viewModel.listState.observe(viewLifecycleOwner) {
            binding.progress.isInvisible = true
            mAdapter?.setItems(list = it)
        }

        viewModel.progressState.observe(viewLifecycleOwner) { show ->
            binding.progress.isVisible = show
        }

        viewModel.fetchPokemonData()
    }

    override fun itemSelect(data: PokemonDataModel) {

        viewModel.setItemSelection(data) //Actualiza el item seleccionado

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(android.R.id.content, PokemonDetailFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()

        //findNavController().navigate(R.id.go_to_pokemonDetailFragment)

    }
}

interface ClickListener {
    fun itemSelect(data: PokemonDataModel)
}