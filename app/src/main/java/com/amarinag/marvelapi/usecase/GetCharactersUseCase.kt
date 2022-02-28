package com.amarinag.marvelapi.usecase

import com.amarinag.domain.model.Character
import com.amarinag.marvelapi.data.repository.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class GetCharactersUseCase @Inject constructor(private val characterRepository: CharacterRepository) {
    suspend operator fun invoke(): Flow<Result<List<Character>>> {
        return characterRepository.getAll()
    }
}