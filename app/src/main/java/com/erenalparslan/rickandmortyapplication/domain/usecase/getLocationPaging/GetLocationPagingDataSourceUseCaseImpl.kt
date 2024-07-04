package com.erenalparslan.rickandmortyapplication.domain.usecase.getLocationPaging

import androidx.paging.PagingData
import com.erenalparslan.rickandmortyapplication.domain.entity.LocationEntity
import com.erenalparslan.rickandmortyapplication.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationPagingDataSourceUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
):GetLocationPagingDataSourceUseCase {
    override fun invoke(): Flow<PagingData<LocationEntity>> {
     return rickAndMortyRepository.getAllRickAndMortyLocations()
 }
}