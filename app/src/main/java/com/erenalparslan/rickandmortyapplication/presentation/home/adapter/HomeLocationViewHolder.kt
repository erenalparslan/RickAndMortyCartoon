package com.erenalparslan.rickandmortyapplication.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.erenalparslan.rickandmortyapplication.databinding.RowLocationHorizontalBinding
import com.erenalparslan.rickandmortyapplication.domain.entity.LocationEntity

class HomeLocationViewHolder(private val binding: RowLocationHorizontalBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(locationEntity: LocationEntity) {
        binding.textView2.text = locationEntity.name
    }
}