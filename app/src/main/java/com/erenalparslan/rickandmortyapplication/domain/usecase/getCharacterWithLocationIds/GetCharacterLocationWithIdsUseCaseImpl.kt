package com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithLocationIds

import com.erenalparslan.rickandmortyapplication.common.NetworkResult
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity
import com.erenalparslan.rickandmortyapplication.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterLocationWithIdsUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
):GetCharacterLocationWithIdsUseCase {
    override suspend fun invoke(urlList: List<String>): NetworkResult<List<CharacterEntity>> {
        return rickAndMortyRepository.getCharactersWithRickAndMortyLocation(urlList)
    }
}