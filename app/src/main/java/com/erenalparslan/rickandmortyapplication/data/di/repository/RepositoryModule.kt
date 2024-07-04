package com.erenalparslan.rickandmortyapplication.data.di.repository

import com.erenalparslan.rickandmortyapplication.domain.repository.RickAndMortyRepository
import com.erenalparslan.rickandmortyapplication.data.repository.RickAndMortyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(
        rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl,
    ): RickAndMortyRepository
}