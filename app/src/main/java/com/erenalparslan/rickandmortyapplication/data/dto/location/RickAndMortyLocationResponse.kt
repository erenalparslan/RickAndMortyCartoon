package com.erenalparslan.rickandmortyapplication.data.dto.location

import com.google.gson.annotations.SerializedName

data class RickAndMortyLocationResponse(
    @SerializedName("info")
    var info: Info,
    @SerializedName("results")
    var results: ArrayList<Results>,
)