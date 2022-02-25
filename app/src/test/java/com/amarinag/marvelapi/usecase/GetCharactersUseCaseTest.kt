package com.amarinag.marvelapi.usecase

import com.amarinag.marvelapi.data.repository.CharacterRepository
import com.amarinag.marvelapi.domain.model.Character
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCharactersUseCaseTest {
    @MockK
    lateinit var characterRepository: CharacterRepository

    private lateinit var charactersUseCase: GetCharactersUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        charactersUseCase = GetCharactersUseCase(characterRepository)
    }

    @Test
    fun `when invoke GetCharactersUseCase call getAll from repository`() = runBlocking {
        val expected = emptyFlow<Result<List<Character>>>()
        coEvery { characterRepository.getAll() } returns expected
        val charactersUseCase = GetCharactersUseCase(characterRepository)
        val response = charactersUseCase()
        coVerify(exactly = 1) { characterRepository.getAll() }

        assertThat(response).isEqualTo(expected)
    }
}