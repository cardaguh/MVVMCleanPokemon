package co.cyclopsapps.mvvmcleanpokemon.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.mvvmcleanpokemon.databinding.PokemonRowBinding
import co.cyclopsapps.mvvmcleanpokemon.model.PokemonDataModel
import com.bumptech.glide.Glide

class ItemViewHolder(binding: PokemonRowBinding) : RecyclerView.ViewHolder(binding.root) {
    private var binding: PokemonRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: PokemonDataModel) {
        binding?.let { view ->
            view.name = model.name

            Glide.with(view.root.context).load(model.img).into(view.imgCharacter)
        }
    }

}
