package com.amarinag.marvelapi.usecase

import com.amarinag.domain.model.Character
import com.amarinag.marvelapi.data.repository.CharacterRepository
import com.amarinag.marvelapi.di.AppDispatchers
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class GetCharacterByIdUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val dispatchers: AppDispatchers
) {
    suspend operator fun invoke(characterId: Long): Result<Character> =
        withContext(dispatchers.io) {
            characterRepository.findById(characterId)
        }
}