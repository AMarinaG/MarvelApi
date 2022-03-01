package com.amarinag.marvelapi.data.network

import com.amarinag.marvelapi.data.network.model.MarvelApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {
    @GET("characters")
    suspend fun getAllCharacter(@Query("offset") offset: Int = 0): MarvelApiResponse

    @GET("characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: Long): MarvelApiResponse
}