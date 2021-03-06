package com.amarinag.marvelapi.domain.model

data class Character(
    val id: Long,
    val name: String,
    val description: String?,
    val imageUrl: String?
)
