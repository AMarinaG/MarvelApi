package com.amarinag.marvelapi.data.source

import com.amarinag.marvelapi.data.network.MarvelApiService
import com.amarinag.marvelapi.data.network.model.MarvelApiResponse
import com.amarinag.marvelapi.di.AppDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRemoteDataSource @Inject constructor(
    private val marvelApiService: MarvelApiService,
    private val appDispatchers: AppDispatchers
) {
    suspend fun getAll(): MarvelApiResponse = withContext(appDispatchers.io) {
        marvelApiService.getAllCharacter()
    }
}