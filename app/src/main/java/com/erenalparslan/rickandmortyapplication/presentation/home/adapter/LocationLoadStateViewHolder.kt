package com.erenalparslan.rickandmortyapplication.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.erenalparslan.rickandmortyapplication.databinding.RowLocationHorizontalLoadStateBinding

class LocationLoadStateViewHolder(
    private val binding: RowLocationHorizontalLoadStateBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.isVisible = loadState is LoadState.Loading
        binding.retryButton.isVisible = loadState is LoadState.Error
        binding.errorMsg.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): LocationLoadStateViewHolder {
            val binding = RowLocationHorizontalLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LocationLoadStateViewHolder(binding, retry)
        }
    }
}