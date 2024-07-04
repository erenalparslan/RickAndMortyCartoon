package com.erenalparslan.rickandmortyapplication.data.source

import com.erenalparslan.rickandmortyapplication.common.NetworkResult
import com.erenalparslan.rickandmortyapplication.data.dto.character.CharacterResponse
import com.erenalparslan.rickandmortyapplication.data.dto.location.Results


interface RemoteDataSource {
    suspend fun getAllRickAndMortyLocation(pageSize:Int): NetworkResult<List<Results>>
    suspend fun getCharactersWithRickAndMortyLocation(ids:String): NetworkResult<List<CharacterResponse>>
    suspend fun getCharacterWithID(id:String):NetworkResult<CharacterResponse>
}