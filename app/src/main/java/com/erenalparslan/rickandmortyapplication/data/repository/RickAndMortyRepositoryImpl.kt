package com.erenalparslan.rickandmortyapplication.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.erenalparslan.rickandmortyapplication.common.NetworkResult
import com.erenalparslan.rickandmortyapplication.util.extractIdsFromUrls
import com.erenalparslan.rickandmortyapplication.data.api.RickAndMortyApi
import com.erenalparslan.rickandmortyapplication.data.di.coroutine.IoDispatcher
import com.erenalparslan.rickandmortyapplication.data.mapper.RickAndMortLocationMapper
import com.erenalparslan.rickandmortyapplication.data.mapper.RickAndMortyCharacterListMapper
import com.erenalparslan.rickandmortyapplication.data.mapper.RickAndMortyCharacterMapper
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity
import com.erenalparslan.rickandmortyapplication.domain.entity.LocationEntity
import com.erenalparslan.rickandmortyapplication.domain.repository.RickAndMortyRepository
import com.erenalparslan.rickandmortyapplication.data.source.PagingDataSourceLocation
import com.erenalparslan.rickandmortyapplication.data.source.RemoteDataSource
import com.erenalparslan.rickandmortyapplication.util.toDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi,
    private val remoteDataSource: RemoteDataSource,
    private val rickAndMortLocationMapper: RickAndMortLocationMapper,
    private val rickAndMortyCharacterListMapper: RickAndMortyCharacterListMapper,
    private val rickAndMortyCharacterMapper: RickAndMortyCharacterMapper,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : RickAndMortyRepository {
    override fun getAllRickAndMortyLocations(): Flow<PagingData<LocationEntity>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = {
                PagingDataSourceLocation(
                    rickAndMortyApi,
                    rickAndMortLocationMapper
                )
            }
        ).flow
    }

    override suspend fun getRickAndMortyCharacterWithId(id: String): NetworkResult<CharacterEntity> {
        return withContext(ioDispatcher){
            val response=remoteDataSource.getCharacterWithID(id)
            return@withContext response.toDomain(rickAndMortyCharacterMapper)
        }
    }

    override suspend fun getCharactersWithRickAndMortyLocation(urlList: List<String>): NetworkResult<List<CharacterEntity>> {
      return withContext(ioDispatcher) {
           val response = remoteDataSource.getCharactersWithRickAndMortyLocation(extractIdsFromUrls(urlList).toString())
           return@withContext response.toDomain(rickAndMortyCharacterListMapper)
       }
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }
}