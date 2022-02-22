package com.amarinag.marvelapi.data.repository

import com.amarinag.marvelapi.data.network.model.MarvelApiResponse
import com.amarinag.marvelapi.data.source.CharacterRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(private val characterRemoteDataSource: CharacterRemoteDataSource) {
    suspend fun getAll(): Result<MarvelApiResponse> =
        Result.success(characterRemoteDataSource.getAll())
}