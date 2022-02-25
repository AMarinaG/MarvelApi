package com.amarinag.marvelapi.data.source

import com.amarinag.marvelapi.data.db.CharacterDao
import com.amarinag.marvelapi.data.db.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterLocalDataSource @Inject constructor(private val characterDao: CharacterDao) {
    fun findAll(): Flow<Result<List<CharacterEntity>>> =
        characterDao.findAll().map { Result.success(it) }
            .catch { Result.failure<List<CharacterEntity>>(it) }

    suspend fun save(characters: List<CharacterEntity>) = characterDao.save(characters)
}