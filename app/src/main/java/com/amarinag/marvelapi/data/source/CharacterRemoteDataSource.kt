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
    suspend fun getAll(): Result<MarvelApiResponse> = withContext(appDispatchers.io) {
        try {
            Result.success(marvelApiService.getAllCharacter())
        } catch (ex: Exception) {
            Result.failure(IllegalArgumentException("Network Exception"))
        }
    }

    suspend fun getById(characterId: Long): Result<MarvelApiResponse> =
        withContext(appDispatchers.io) {
            try {
                val response = marvelApiService.getCharacterById(characterId)
                Result.success(response)
            } catch (ex: Exception) {
                Result.failure(IllegalArgumentException("Network Exception"))
            }
        }
}