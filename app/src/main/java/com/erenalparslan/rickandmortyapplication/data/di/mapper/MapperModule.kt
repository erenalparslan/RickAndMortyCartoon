package com.erenalparslan.rickandmortyapplication.data.di.mapper

import com.erenalparslan.rickandmortyapplication.common.ListMapper
import com.erenalparslan.rickandmortyapplication.common.Mapper
import com.erenalparslan.rickandmortyapplication.data.dto.character.CharacterResponse
import com.erenalparslan.rickandmortyapplication.data.dto.location.Results
import com.erenalparslan.rickandmortyapplication.data.mapper.RickAndMortLocationMapper
import com.erenalparslan.rickandmortyapplication.data.mapper.RickAndMortyCharacterListMapper
import com.erenalparslan.rickandmortyapplication.data.mapper.RickAndMortyCharacterMapper
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity
import com.erenalparslan.rickandmortyapplication.domain.entity.LocationEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyLocationMapper(rickAndMortLocationMapper: RickAndMortLocationMapper): ListMapper<Results, LocationEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyCharacterListMapper(rickAndMortyCharacterListMapper: RickAndMortyCharacterListMapper): ListMapper<CharacterResponse, CharacterEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyCharacterMapper(rickAndMortyCharacterMapper: RickAndMortyCharacterMapper): Mapper<CharacterResponse, CharacterEntity>

}