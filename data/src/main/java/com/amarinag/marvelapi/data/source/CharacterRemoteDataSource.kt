package com.amarinag.marvelapi.data.source

import com.amarinag.marvelapi.domain.model.Character

interface CharacterRemoteDataSource {
    suspend fun getAll(): Result<List<Character>>
    suspend fun getById(characterId: Long): Result<Character>

}