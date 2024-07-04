package com.erenalparslan.rickandmortyapplication.data.mapper

import com.erenalparslan.rickandmortyapplication.data.dto.character.CharacterResponse
import com.erenalparslan.rickandmortyapplication.common.ListMapper
import com.erenalparslan.rickandmortyapplication.util.extractIdsFromUrls
import com.erenalparslan.rickandmortyapplication.util.formatDateTime
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity
import javax.inject.Inject

class RickAndMortyCharacterListMapper @Inject constructor() :
    ListMapper<CharacterResponse, CharacterEntity> {
    override fun map(input: List<CharacterResponse>): List<CharacterEntity> {
        return input.map {
            CharacterEntity(
                id = it.id,
                image = it.image,
                status = it.status,
                created = formatDateTime(it.created),
                type = it.type,
                gender = it.gender,
                species = it.species,
                name = it.name,
                location = it.location.name,
                origin = it.origin.name,
                episodes = extractIdsFromUrls(it.episode).toString()
            )
        }
    }
}