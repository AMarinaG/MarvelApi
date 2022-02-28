package com.amarinag.marvelapi.di

import com.amarinag.marvelapi.data.db.CharacterDao
import com.amarinag.marvelapi.data.network.MarvelApiService
import com.amarinag.marvelapi.data.repository.CharacterRepositoryImpl
import com.amarinag.marvelapi.data.source.CharacterRemoteDataSource
import com.amarinag.marvelapi.data.source.MarvelCharacterLocalDataSource
import com.amarinag.marvelapi.data.source.MarvelCharacterRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideCoroutinesDispatcher(): AppDispatchers = AppDispatchers()

    @Singleton
    @Provides
    fun provideCharacterRepository(
        characterLocalDataSource: MarvelCharacterLocalDataSource,
        characterRemoteDataSource: CharacterRemoteDataSource
    ): CharacterRepositoryImpl =
        CharacterRepositoryImpl(characterRemoteDataSource, characterLocalDataSource)

    @Singleton
    @Provides
    fun provideCharacterLocalDataSource(characterDao: CharacterDao): MarvelCharacterLocalDataSource =
        MarvelCharacterLocalDataSource(characterDao)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(
        marvelApiService: MarvelApiService,
        appDispatchers: AppDispatchers
    ): MarvelCharacterRemoteDataSource =
        MarvelCharacterRemoteDataSource(marvelApiService, appDispatchers)
}