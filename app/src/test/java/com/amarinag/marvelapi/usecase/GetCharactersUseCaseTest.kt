package com.amarinag.marvelapi.usecase

import com.amarinag.marvelapi.data.repository.CharacterRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCharactersUseCaseTest {
    @MockK
    private lateinit var characterRepository: CharacterRepository
    private lateinit var getCharactersUseCase: GetCharactersUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        getCharactersUseCase = GetCharactersUseCase(characterRepository)
    }

    @Test
    fun `when calls GetCharactersUseCase calls characterRepository getAll`() = runBlocking {
        coEvery { characterRepository.getAll() } returns emptyFlow()

        getCharactersUseCase()

        coVerify(exactly = 1) { characterRepository.getAll() }
    }
}