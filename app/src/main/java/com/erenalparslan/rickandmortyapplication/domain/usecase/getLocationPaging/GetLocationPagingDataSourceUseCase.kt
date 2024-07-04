package com.erenalparslan.rickandmortyapplication.domain.usecase.getLocationPaging

import androidx.paging.PagingData
import com.erenalparslan.rickandmortyapplication.domain.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface GetLocationPagingDataSourceUseCase {
    operator fun invoke(): Flow<PagingData<LocationEntity>>
}