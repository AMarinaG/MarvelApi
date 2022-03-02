package com.amarinag.marvelapi.data.source

import com.amarinag.marvelapi.data.network.MarvelApiService
import com.amarinag.marvelapi.data.network.model.toModel
import com.amarinag.marvelapi.di.AppDispatchers
import com.amarinag.marvelapi.domain.model.Character
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarvelCharacterRemoteDataSource @Inject constructor(
    private val marvelApiService: MarvelApiService,
    private val appDispatchers: AppDispatchers
) : CharacterRemoteDataSource {
    override suspend fun getAll(): Result<List<Character>> = withContext(appDispatchers.io) {
        try {
            Result.success(marvelApiService.getAllCharacter().data?.results.toModel())
        } catch (ex: Exception) {
            Result.failure(IllegalArgumentException("Network Exception"))
        }
    }

    override suspend fun getById(characterId: Long): Result<Character> =
        withContext(appDispatchers.io) {
            try {
                val response = marvelApiService.getCharacterById(characterId)
                response.data?.results?.first()?.toModel()?.let {
                    Result.success(it)
                } ?: Result.failure(IllegalArgumentException("Servar fails"))
            } catch (ex: Exception) {
                Result.failure(IllegalArgumentException("Network Exception"))
            }
        }
}

