package com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithId

import com.erenalparslan.rickandmortyapplication.common.NetworkResult
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity

interface GetCharacterWithIdUseCase{
    suspend operator fun invoke(id:String):NetworkResult<CharacterEntity>
}