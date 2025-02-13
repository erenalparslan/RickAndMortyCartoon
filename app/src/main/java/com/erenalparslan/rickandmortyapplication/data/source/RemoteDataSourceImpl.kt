package com.example.data.source

import com.erenalparslan.rickandmortyapplication.common.NetworkResult
import com.erenalparslan.rickandmortyapplication.common.ResultError
import com.erenalparslan.rickandmortyapplication.data.api.RickAndMortyApi
import com.erenalparslan.rickandmortyapplication.data.dto.character.CharacterResponse
import com.erenalparslan.rickandmortyapplication.data.dto.location.Results
import com.erenalparslan.rickandmortyapplication.data.source.RemoteDataSource

import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
): RemoteDataSource {
    override suspend fun getAllRickAndMortyLocation(pageSize:Int): NetworkResult<List<Results>> {
       return try {
           NetworkResult.Success(rickAndMortyApi.getRickAndMortyLocation(pageSize).results)
       }catch (e: IOException){
           NetworkResult.Error.IOException(
               ResultError(
                   errorMessage = e.localizedMessage ?: ""
               )
           )
       }catch (e:HttpException){
           NetworkResult.Error.ApiError(
               ResultError(
                   errorMessage = e.localizedMessage ?: ""
               )
           )
       }
    }

    override suspend fun getCharactersWithRickAndMortyLocation(ids: String): NetworkResult<List<CharacterResponse>> {
        return try {
           NetworkResult.Success(rickAndMortyApi.getCharactersWithRickAndMortyLocation(ids))
        }catch (e: IOException){
            NetworkResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }catch (e:HttpException){
            NetworkResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    override suspend fun getCharacterWithID(id: String): NetworkResult<CharacterResponse> {
        return try {
            NetworkResult.Success(rickAndMortyApi.getCharacterWithId(id))
        }catch (e: IOException){
            NetworkResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }catch (e:HttpException){
            NetworkResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }
}