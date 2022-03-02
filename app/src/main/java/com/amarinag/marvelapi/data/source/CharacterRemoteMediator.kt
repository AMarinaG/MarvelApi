package com.amarinag.marvelapi.data.source

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.amarinag.marvelapi.data.db.entity.CharacterEntity
import com.amarinag.marvelapi.data.network.MarvelApiService
import com.amarinag.marvelapi.data.network.model.toModel
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalPagingApi
@Singleton
class CharacterRemoteMediator @Inject constructor(
    private val marvelApiService: MarvelApiService,
    private val marvelCharacterLocalDataSource: MarvelCharacterLocalDataSource
) : RemoteMediator<Int, CharacterEntity>() {
    private var offset: Int = 0
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        return try {
            Log.d("MediatorResult", "loadType: $loadType")
            return when (loadType) {
                LoadType.REFRESH -> {
                    val response = marvelApiService.getAllCharacter(offset = 0)
                    offset = response.data?.offset?.plus(response.data.limit) ?: 0
                    marvelCharacterLocalDataSource.save(response.data?.results.toModel())
                    MediatorResult.Success(endOfPaginationReached = false)
                }
                LoadType.PREPEND -> MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val response = marvelApiService.getAllCharacter(offset = offset)
                    offset = response.data?.offset?.plus(response.data.limit) ?: 0
                    marvelCharacterLocalDataSource.save(response.data?.results.toModel())
                    MediatorResult.Success(endOfPaginationReached = false)
                }
            }
        } catch (ex: Exception) {
            MediatorResult.Error(ex)
        }
    }

}