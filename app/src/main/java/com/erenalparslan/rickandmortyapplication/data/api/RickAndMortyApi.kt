package com.erenalparslan.rickandmortyapplication.data.api

import com.erenalparslan.rickandmortyapplication.data.dto.character.CharacterResponse
import com.erenalparslan.rickandmortyapplication.data.dto.location.RickAndMortyLocationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("location")
    suspend fun getRickAndMortyLocation(
        @Query("page") page: Int
    ): RickAndMortyLocationResponse

    @GET("character/{ids}")
    suspend fun getCharactersWithRickAndMortyLocation(
        @Path("ids") ids: String
    ): List<CharacterResponse>

    @GET("character/{id}")
    suspend fun getCharacterWithId(
        @Path("id") id: String
    ): CharacterResponse

}