package com.erenalparslan.rickandmortyapplication.domain.entity

data class LocationEntity(
    val id: Int,
    val name: String,
    val residents: ArrayList<String>,
    var isSelected: Boolean = false
    )