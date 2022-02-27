package com.amarinag.marvelapi.data.source

import android.util.Log
import com.amarinag.marvelapi.data.network.MarvelApiService
import com.amarinag.marvelapi.data.network.model.MarvelApiResponse
import com.amarinag.marvelapi.di.AppDispatchers
import kotlinx.coroutines.delay
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
            Result.failure(ex)
        }
    }
    suspend fun getById(characterId: Long): Result<MarvelApiResponse> = withContext(appDispatchers.io) {
        try {
            val response = marvelApiService.getCharacterById(characterId)
            Log.d("AMG", "responsedatasource: $response")
            Result.success(response)
        } catch (ex: Exception) {
            Log.d("AMG", "ex: $ex")
            Result.failure(ex)
        }
    }
}