package com.amarinag.marvelapi.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.amarinag.marvelapi.data.network.MarvelApiService
import com.amarinag.marvelapi.data.network.model.toModel
import com.amarinag.marvelapi.domain.model.Character
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

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
        val response = marvelApiService.getAllCharacter(nextPageNumber)
        LoadResult.Page(
            data = response.data?.results.toModel(),
            prevKey = null,
            nextKey = response.data?.offset?.plus(response.data.limit)
        )
    } catch (ioe: IOException) {
        LoadResult.Error(ioe)
    } catch (ex: Exception) {
        LoadResult.Error(ex)
    }
}

