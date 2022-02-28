package com.amarinag.marvelapi.data.repository

import com.amarinag.marvelapi.data.source.CharacterLocalDataSource
import com.amarinag.marvelapi.data.source.CharacterRemoteDataSource
import com.amarinag.marvelapi.domain.model.Character
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CharacterRepositoryTest {

    @MockK
    private lateinit var characterRemoteDataSource: CharacterRemoteDataSource

    @MockK
    private lateinit var characterLocalDataSource: CharacterLocalDataSource
    private lateinit var repository: CharacterRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        repository = CharacterRepositoryImpl(characterRemoteDataSource, characterLocalDataSource)
    }

    @Test
    fun `get all character from server`() = runBlocking {
        coEvery { characterRemoteDataSource.getAll() } returns Result.success(emptyList())
        coEvery { characterLocalDataSource.findAll() } returns flow { emit(Result.success(emptyList())) }

        val flowResponse = repository.getAll()

        coVerify(exactly = 1) { characterRemoteDataSource.getAll() }
        coVerify(exactly = 1) { characterLocalDataSource.save(any()) }
        coVerify(exactly = 1) { characterLocalDataSource.findAll() }
        assertThat(flowResponse.first().isSuccess).isEqualTo(true)
        assertThat(flowResponse.first().getOrNull()).isEqualTo(emptyList<Character>())

    }
}