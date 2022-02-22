package com.amarinag.marvelapi.usecase

import com.amarinag.marvelapi.data.network.model.toModel
import com.amarinag.marvelapi.data.repository.CharacterRepository
import com.amarinag.marvelapi.domain.model.Character
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetCharactersUseCase @Inject constructor(private val characterRepository: CharacterRepository) {
    suspend operator fun invoke(): Result<List<Character>> {
        return characterRepository.getAll().map { it.data?.results.toModel() }
    }
}