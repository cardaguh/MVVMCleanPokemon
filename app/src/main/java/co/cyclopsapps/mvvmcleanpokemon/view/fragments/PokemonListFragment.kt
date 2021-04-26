package co.cyclopsapps.mvvmcleanpokemon.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.cyclopsapps.mvvmcleanpokemon.R
import co.cyclopsapps.mvvmcleanpokemon.databinding.FragmentPokemonListBinding
import co.cyclopsapps.mvvmcleanpokemon.view.adapter.ItemsAdapter
import co.cyclopsapps.mvvmcleanpokemon.viewmodels.RecyclerPokemonViewModel

class PokemonListFragment : Fragment() {
    lateinit var viewModel: RecyclerPokemonViewModel
    lateinit var binding: FragmentPokemonListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecyclerPokemonViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_pokemon_list, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        val mAdapter = ItemsAdapter()

        viewModel.itemSelected.observe(viewLifecycleOwner) {
            it?.let {

                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(android.R.id.content, PokemonDetailFragment.newInstance())
                    ?.addToBackStack(null)?.commitNowAllowingStateLoss()
            }
        }

        viewModel.listState.observe(viewLifecycleOwner) {
            mAdapter.setItems(list = it)
        }

        viewModel.fetchPokemonData()
    }
}