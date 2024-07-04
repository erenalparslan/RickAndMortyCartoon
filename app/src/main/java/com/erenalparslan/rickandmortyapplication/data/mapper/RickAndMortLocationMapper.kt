package com.erenalparslan.rickandmortyapplication.data.mapper

import com.erenalparslan.rickandmortyapplication.data.dto.location.Results
import com.erenalparslan.rickandmortyapplication.common.ListMapper
import com.erenalparslan.rickandmortyapplication.domain.entity.LocationEntity
import javax.inject.Inject

class RickAndMortLocationMapper @Inject constructor() : ListMapper<Results, LocationEntity> {
    override fun map(input: List<Results>): List<LocationEntity> {
        return input.map {
            LocationEntity(
                id = it.id,
                name = it.name,
                residents = it.residents
            )
        }
    }
}