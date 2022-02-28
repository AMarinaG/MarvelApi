package com.amarinag.marvelapi.di

import com.amarinag.marvelapi.data.repository.CharacterRepository
import com.amarinag.marvelapi.data.repository.CharacterRepositoryImpl
import com.amarinag.marvelapi.data.source.CharacterLocalDataSource
import com.amarinag.marvelapi.data.source.CharacterRemoteDataSource
import com.amarinag.marvelapi.data.source.MarvelCharacterLocalDataSource
import com.amarinag.marvelapi.data.source.MarvelCharacterRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindingModule {

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRepository

    @Binds
    @Singleton
    abstract fun bindCharacterRemoteDataSource(marvelCharacterRemoteDataSource: MarvelCharacterRemoteDataSource): CharacterRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindCharacterLocalDataSource(marvelCharacterLocalDataSource: MarvelCharacterLocalDataSource): CharacterLocalDataSource
}