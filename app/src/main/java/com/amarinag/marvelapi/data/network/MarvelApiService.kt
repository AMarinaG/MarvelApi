package com.amarinag.marvelapi.data.network

import com.amarinag.marvelapi.data.network.model.MarvelApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelApiService {
    @GET("characters")
    suspend fun getAllCharacter(): MarvelApiResponse

    @GET("characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: Long): MarvelApiResponse
}