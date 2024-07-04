package com.erenalparslan.rickandmortyapplication.domain.di

import com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithId.GetCharacterWithIdUseCase
import com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithId.GetCharacterWithIdUseCaseImpl
import com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithLocationIds.GetCharacterLocationWithIdsUseCase
import com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithLocationIds.GetCharacterLocationWithIdsUseCaseImpl
import com.erenalparslan.rickandmortyapplication.domain.usecase.getLocationPaging.GetLocationPagingDataSourceUseCase
import com.erenalparslan.rickandmortyapplication.domain.usecase.getLocationPaging.GetLocationPagingDataSourceUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindGetCharacterWithIdUseCase(getCharacterWithIdUseCaseImpl: GetCharacterWithIdUseCaseImpl): GetCharacterWithIdUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetRickAndMortyLocationPaging(getLocationPagingDataSourceUseCaseImpl: GetLocationPagingDataSourceUseCaseImpl):GetLocationPagingDataSourceUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetCharactersWithLocationIds(getCharacterLocationWithIdsUseCaseImpl: GetCharacterLocationWithIdsUseCaseImpl):GetCharacterLocationWithIdsUseCase
}