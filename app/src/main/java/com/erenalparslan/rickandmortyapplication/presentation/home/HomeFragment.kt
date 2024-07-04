package com.erenalparslan.rickandmortyapplication.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.erenalparslan.rickandmortyapplication.R
import com.erenalparslan.rickandmortyapplication.common.viewBinding
import com.erenalparslan.rickandmortyapplication.databinding.FragmentHomeBinding
import com.erenalparslan.rickandmortyapplication.rickandmorty.ui.home.HomeUiState
import com.erenalparslan.rickandmortyapplication.common.gone
import com.erenalparslan.rickandmortyapplication.rickandmorty.ui.home.adapter.HomeCharacterAdapter
import com.erenalparslan.rickandmortyapplication.presentation.home.adapter.HomeLocationAdapter
import com.erenalparslan.rickandmortyapplication.presentation.home.adapter.LocationLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment:Fragment(R.layout.fragment_home) {
    private val viewModel by viewModels<HomeViewModel>()
    private val locationAdapter by lazy { HomeLocationAdapter(::clickLocation) }
    private val characterAdapter by lazy { HomeCharacterAdapter(::clickCharacter) }
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        observeLiveData()
    }

    private fun initAdapters() {
        binding.horizontalRcv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRcv.adapter = locationAdapter.withLoadStateHeaderAndFooter(
            header = LocationLoadStateAdapter { locationAdapter.retry() },
            footer = LocationLoadStateAdapter { locationAdapter.retry() }
        )
        binding.verticalRcv.adapter = characterAdapter
        binding.verticalRcv.layoutManager = LinearLayoutManager(requireContext())

        collectLatest(viewModel.locationList) {
            locationAdapter.submitData(it)
        }
    }

    private fun clickLocation(urlList: List<String>) {
        viewModel.getCharactersWithLocationIds(urlList)
    }

    private fun clickCharacter(i: Int) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(i.toString()))

    }

    private fun observeLiveData() {
        viewModel.homeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Success -> {
                    characterAdapter.updateCharacterAdapterData(it.data)
                    binding.shimmerFrameLayout.gone()
                }

                is HomeUiState.Error -> {
                    Log.e("Home Fragment", "Error: ${it.message}")
                }

                is HomeUiState.Loading -> {
                    binding.shimmerFrameLayout.showShimmer(true)
                }
            }
        }
    }

    fun <T> Fragment.collectLatest(flow: Flow<T>, action: suspend (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collectLatest {
                    action(it)
                }
            }
        }
    }
}