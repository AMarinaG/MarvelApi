package com.amarinag.marvelapi.data.repository

import com.amarinag.marvelapi.data.db.entity.toModel
import com.amarinag.marvelapi.data.network.model.toEntity
import com.amarinag.marvelapi.data.network.model.toModel
import com.amarinag.marvelapi.data.source.CharacterLocalDataSource
import com.amarinag.marvelapi.data.source.CharacterRemoteDataSource
import com.amarinag.marvelapi.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val characterRemoteDataSource: CharacterRemoteDataSource,
    private val characterLocalDataSource: CharacterLocalDataSource
) {
    suspend fun getAll(): Flow<Result<List<Character>>> {
        val dataFromServer = characterRemoteDataSource.getAll()
        dataFromServer.onSuccess {
            characterLocalDataSource.save(it.data?.results.toEntity())
        }.onFailure {
            Result.failure<List<Character>>(IllegalArgumentException("something was wrong"))
        }
        return characterLocalDataSource.findAll().map { result -> result.map { it.toModel() } }
    }

    suspend fun findById(characterId: Long): Result<Character> =
        characterLocalDataSource.findById(characterId).map { it.toModel() }.recoverCatching {
            characterRemoteDataSource.getById(characterId).getOrThrow().data?.results?.first()?.toModel()!!
        }
}