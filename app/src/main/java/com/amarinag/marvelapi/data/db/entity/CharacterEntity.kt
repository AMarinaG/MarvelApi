package com.amarinag.marvelapi.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.amarinag.marvelapi.domain.model.Character

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "name") val name: String
)


fun CharacterEntity.toModel(): Character = Character(id, name)
fun List<CharacterEntity>?.toModel(): List<Character> = this?.map { it.toModel() } ?: emptyList()

fun Character.toEntity(): CharacterEntity = CharacterEntity(id, name)
fun List<Character>?.toEntity(): List<CharacterEntity> = this?.map { it.toEntity() } ?: emptyList()