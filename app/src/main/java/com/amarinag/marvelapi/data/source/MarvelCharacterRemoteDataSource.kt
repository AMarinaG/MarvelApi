package com.amarinag.marvelapi.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.amarinag.marvelapi.data.network.MarvelApiService
import com.amarinag.marvelapi.data.network.model.toModel
import com.amarinag.marvelapi.di.AppDispatchers
import com.amarinag.marvelapi.domain.model.Character
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarvelCharacterRemoteDataSource @Inject constructor(
    private val marvelApiService: MarvelApiService,
    private val appDispatchers: AppDispatchers
) : CharacterRemoteDataSource {
    override suspend fun getAll(): Result<List<Character>> = withContext(appDispatchers.io) {
        try {
            Result.success(marvelApiService.getAllCharacter().data?.results.toModel())
        } catch (ex: Exception) {
            Result.failure(IllegalArgumentException("Network Exception"))
        }
    }

    override suspend fun getById(characterId: Long): Result<Character> =
        withContext(appDispatchers.io) {
            try {
                val response = marvelApiService.getCharacterById(characterId)
                response.data?.results?.first()?.toModel()?.let {
                    Result.success(it)
                } ?: Result.failure(IllegalArgumentException("Servar fails"))
            } catch (ex: Exception) {
                Result.failure(IllegalArgumentException("Network Exception"))
            }
        }
}

@Singleton
class CharacterPagingSource @Inject constructor(
    private val marvelApiService: MarvelApiService
) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> = try {
        val nextPageNumber = params.key ?: 0
        delay(5000)
        val response = marvelApiService.getAllCharacter(nextPageNumber)
        LoadResult.Page(
            data = response.data?.results.toModel(),
            prevKey = null,
            nextKey = response.data?.offset?.plus(response.data.limit)
        )
    } catch (ex: Exception) {
        LoadResult.Error(ex)
    }
}