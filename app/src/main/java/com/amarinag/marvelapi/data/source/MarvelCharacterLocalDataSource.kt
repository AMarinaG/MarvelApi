package com.amarinag.marvelapi.data.source

import com.amarinag.marvelapi.data.db.CharacterDao
import com.amarinag.marvelapi.data.db.entity.toEntity
import com.amarinag.marvelapi.data.db.entity.toModel
import com.amarinag.marvelapi.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MarvelCharacterLocalDataSource(private val characterDao: CharacterDao) :
    CharacterLocalDataSource {

    override fun findAll(): Flow<Result<List<Character>>> = flow {
        try {
            emitAll(characterDao.findAll().map { Result.success(it.toModel()) })
        } catch (ex: Exception) {
            emit(Result.failure(IllegalArgumentException("database error", ex)))
        }
    }

    override suspend fun findById(characterId: Long) =
        characterDao.findById(characterId)?.let {
            Result.success(it.toModel())
        } ?: Result.failure(IllegalArgumentException("Character Not Found"))


    override suspend fun save(characters: List<Character>) {
        characterDao.save(characters.toEntity())
    }
}