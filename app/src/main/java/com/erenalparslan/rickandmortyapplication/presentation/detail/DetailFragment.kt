package com.erenalparslan.rickandmortyapplication.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.erenalparslan.rickandmortyapplication.R
import com.erenalparslan.rickandmortyapplication.common.downloadFromUrl
import com.erenalparslan.rickandmortyapplication.common.viewBinding
import com.erenalparslan.rickandmortyapplication.databinding.FragmentDetailBinding
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val viewModel by viewModels<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentDetailBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        val id = args.id
        viewModel.getRickAndMortyCharacter(id)
        binding.backButtonDetail.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun observeLiveData() {
        viewModel.detailUiState.observe(viewLifecycleOwner) {
            when (it) {
                is DetailUiState.Loading -> {
                }

                is DetailUiState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }

                is DetailUiState.Success -> {
                    it.data?.let { detailData ->
                        setData(detailData)
                    }
                }
            }
        }
    }

    private fun setData(characterEntity: CharacterEntity) {
        binding.apply {
            characterNameText.text = characterEntity.name
            detailCharacterImage.downloadFromUrl(characterEntity.image)
            createdTextDetail2.text = characterEntity.created
            episodesTextDetail2.text = characterEntity.episodes
            genderTextDetail2.text = characterEntity.gender
            originTextDetail2.text = characterEntity.origin
            locationTextDetail2.text = characterEntity.location
            statusTextDetail2.text = characterEntity.status
            specyTextDetail2.text = characterEntity.species
        }
    }
}