package com.erenalparslan.rickandmortyapplication.data.mapper

import com.erenalparslan.rickandmortyapplication.data.dto.character.CharacterResponse
import com.erenalparslan.rickandmortyapplication.common.Mapper
import com.erenalparslan.rickandmortyapplication.util.extractIdsFromUrls
import com.erenalparslan.rickandmortyapplication.util.formatDateTime
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity
import javax.inject.Inject

class RickAndMortyCharacterMapper @Inject constructor() :
    Mapper<CharacterResponse, CharacterEntity> {
    override fun map(input: CharacterResponse): CharacterEntity {
        return CharacterEntity(
            id = input.id,
            image = input.image,
            species = input.species,
            gender = input.gender,
            type = input.type,
            created = formatDateTime(input.created),
            status = input.status,
            name = input.name,
            location = input.location.name,
            origin = input.origin.name,
            episodes = extractIdsFromUrls(input.episode).toString()
        )
    }
}