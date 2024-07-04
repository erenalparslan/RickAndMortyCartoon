package com.erenalparslan.rickandmortyapplication.presentation.home

import com.erenalparslan.rickandmortyapplication.common.ListMapper
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity
import com.erenalparslan.rickandmortyapplication.rickandmorty.ui.home.HomeCharacterUiData
import javax.inject.Inject

class HomeUiCharacterMapper @Inject constructor():
    ListMapper<CharacterEntity, HomeCharacterUiData> {
    override fun map(input: List<CharacterEntity>): List<HomeCharacterUiData> {
        return input.map {
            HomeCharacterUiData(
                id = it.id,
                name = it.name,
                image = it.image,
                gender = it.gender
            )
        }
    }

}