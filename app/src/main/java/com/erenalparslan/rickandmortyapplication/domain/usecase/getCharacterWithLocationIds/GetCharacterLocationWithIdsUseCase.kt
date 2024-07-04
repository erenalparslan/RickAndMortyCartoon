package com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithLocationIds

import com.erenalparslan.rickandmortyapplication.common.NetworkResult
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity

interface GetCharacterLocationWithIdsUseCase {
    suspend operator  fun invoke(urlList: List<String>): NetworkResult<List<CharacterEntity>>
}