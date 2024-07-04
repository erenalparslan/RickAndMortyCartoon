package com.erenalparslan.rickandmortyapplication.domain.repository

import androidx.paging.PagingData
import com.erenalparslan.rickandmortyapplication.common.NetworkResult
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity
import com.erenalparslan.rickandmortyapplication.domain.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getAllRickAndMortyLocations():Flow<PagingData<LocationEntity>>

    suspend fun getRickAndMortyCharacterWithId(id:String): NetworkResult<CharacterEntity>

    suspend fun getCharactersWithRickAndMortyLocation(urlList:List<String>):NetworkResult<List<CharacterEntity>>
}