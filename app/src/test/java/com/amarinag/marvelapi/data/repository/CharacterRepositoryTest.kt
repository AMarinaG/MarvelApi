package com.amarinag.marvelapi.data.repository

import com.amarinag.marvelapi.data.network.model.CharacterResponse
import com.amarinag.marvelapi.data.network.model.MarvelApiResponse
import com.amarinag.marvelapi.data.network.model.toEntity
import com.amarinag.marvelapi.data.source.CharacterLocalDataSource
import com.amarinag.marvelapi.data.source.CharacterRemoteDataSource
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CharacterRepositoryTest {
    @MockK
    lateinit var characterRemoteDataSource: CharacterRemoteDataSource

    @RelaxedMockK
    lateinit var characterLocalDataSource: CharacterLocalDataSource

    lateinit var characterRepository: CharacterRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        characterRepository =
            CharacterRepository(characterRemoteDataSource, characterLocalDataSource)
    }

    @Test
    fun `when server response is ok save on database`() = runBlocking {

        val characterResponse = List(5) {
            CharacterResponse(
                it.toLong(),
                "name $it",
                "description $it",
                "modifier: $it",
                null,
                "resourceUrl $it",
                null,
                null,
                null,
                null,
                emptyList()
            )
        }
        val marvelApiResponse = mockkClass(MarvelApiResponse::class)
        //Given
        coEvery { characterRemoteDataSource.getAll() } returns Result.success(marvelApiResponse)
        coJustRun { characterLocalDataSource.save(marvelApiResponse.data?.results.toEntity()) }
        every { marvelApiResponse.data?.results } returns characterResponse
        //When
        characterRepository.getAll()
        //Then
        coVerify(exactly = 1) { characterRemoteDataSource.getAll() }
        coVerify(exactly = 1) { characterLocalDataSource.save(any()) }
        coVerify(exactly = 1) { characterLocalDataSource.findAll() }
    }

    @Test
    fun `when server response is ko save on database`() = runBlocking {
        //Given
        coEvery { characterRemoteDataSource.getAll() } returns Result.failure(
            IllegalArgumentException("hello Test")
        )
        //When
        characterRepository.getAll()
        //Then
        coVerify(exactly = 1) { characterRemoteDataSource.getAll() }
        coVerify(exactly = 0) { characterLocalDataSource.save(any()) }
        coVerify(exactly = 1) { characterLocalDataSource.findAll() }
    }
}