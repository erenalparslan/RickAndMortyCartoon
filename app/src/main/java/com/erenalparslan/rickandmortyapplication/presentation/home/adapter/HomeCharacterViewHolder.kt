package com.erenalparslan.rickandmortyapplication.presentation.home.adapter



import androidx.recyclerview.widget.RecyclerView
import com.erenalparslan.rickandmortyapplication.databinding.RowCharacterHomeBinding
import com.erenalparslan.rickandmortyapplication.rickandmorty.ui.home.HomeCharacterUiData



class HomeCharacterViewHolder(
    private val characterClick: (Int) -> Unit,
    private val binding: RowCharacterHomeBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(homeCharacterUiData: HomeCharacterUiData) {
        binding.characterComponent.setCharacterData(homeCharacterUiData)
        binding.characterComponent.characterItemClickListener {
            characterClick.invoke(homeCharacterUiData.id)
        }
    }
}