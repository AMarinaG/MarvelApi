package com.amarinag.marvelapi.data.network

import com.amarinag.marvelapi.utils.AppResources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMarvelApiService(appResources: AppResources): MarvelApiService =
        MockService(appResources)

}
