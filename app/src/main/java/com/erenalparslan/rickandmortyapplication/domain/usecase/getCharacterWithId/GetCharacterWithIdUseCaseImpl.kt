package com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithId

import com.erenalparslan.rickandmortyapplication.common.NetworkResult
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity
import com.erenalparslan.rickandmortyapplication.domain.repository.RickAndMortyRepository
import com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithId.GetCharacterWithIdUseCase
import javax.inject.Inject

class GetCharacterWithIdUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
): GetCharacterWithIdUseCase {
    override suspend fun invoke(id:String): NetworkResult<CharacterEntity> {
       return rickAndMortyRepository.getRickAndMortyCharacterWithId(id)
    }
}