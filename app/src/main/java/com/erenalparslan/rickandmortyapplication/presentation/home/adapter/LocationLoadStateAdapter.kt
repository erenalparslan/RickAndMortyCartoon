package com.erenalparslan.rickandmortyapplication.presentation.home.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.erenalparslan.rickandmortyapplication.presentation.home.adapter.LocationLoadStateViewHolder

class LocationLoadStateAdapter (private val retry: () -> Unit) : LoadStateAdapter<LocationLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: LocationLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LocationLoadStateViewHolder {
        return LocationLoadStateViewHolder.create(parent, retry)
    }
}