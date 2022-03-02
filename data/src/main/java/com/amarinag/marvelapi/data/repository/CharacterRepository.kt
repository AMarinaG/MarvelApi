package com.amarinag.marvelapi.data.repository

import com.amarinag.marvelapi.data.source.CharacterLocalDataSource
import com.amarinag.marvelapi.data.source.CharacterRemoteDataSource
import com.amarinag.marvelapi.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAll(offset: Int = 0): Flow<Result<List<Character>>>

    suspend fun findById(characterId: Long): Result<Character>
}

class CharacterRepositoryImpl(
    private val characterRemoteDataSource: CharacterRemoteDataSource,
    private val characterLocalDataSource: CharacterLocalDataSource
) : CharacterRepository {
    override suspend fun getAll(offset: Int): Flow<Result<List<Character>>> {
        val dataFromServer = characterRemoteDataSource.getAll()
        dataFromServer.onSuccess {
            characterLocalDataSource.save(it)
        }.onFailure {
            Result.failure<List<Character>>(IllegalArgumentException("Bad request"))
        }
        return characterLocalDataSource.findAll()
    }

    override suspend fun findById(characterId: Long): Result<Character> =
        characterLocalDataSource.findById(characterId).recoverCatching {
            characterRemoteDataSource.getById(characterId).getOrThrow()
        }
}