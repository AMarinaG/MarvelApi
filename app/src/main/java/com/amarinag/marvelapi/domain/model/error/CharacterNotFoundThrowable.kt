package com.amarinag.marvelapi.domain.model.error

import com.amarinag.marvelapi.R

class CharacterNotFoundThrowable(val characterId: Long): AmgThrowable(R.string.error_character_not_found)