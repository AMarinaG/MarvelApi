package com.amarinag.marvelapi.data.source

import com.amarinag.marvelapi.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterLocalDataSource {
    fun findAll(): Flow<Result<List<Character>>>

    suspend fun findById(characterId: Long): Result<Character>

    suspend fun save(characters: List<Character>)
}