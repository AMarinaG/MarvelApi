package com.amarinag.marvelapi.data.network.model


import com.amarinag.marvelapi.data.db.entity.CharacterEntity
import com.amarinag.marvelapi.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id")
    val id: Long, // 1011334
    @SerializedName("name")
    val name: String, // 3-D Man
    @SerializedName("description")
    val description: String?,
    @SerializedName("modified")
    val modified: String?, // 2014-04-29T14:18:17-0400
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("resourceURI")
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/characters/1011334
    @SerializedName("comics")
    val comics: Comics?,
    @SerializedName("series")
    val series: Series?,
    @SerializedName("stories")
    val stories: Stories?,
    @SerializedName("events")
    val events: Events?,
    @SerializedName("urls")
    val urls: List<Url>?
)

fun CharacterResponse.toModel(): Character = Character(id, name, thumbnail?.imageUrl ?: "")
fun List<CharacterResponse>?.toModel(): List<Character> = this?.map { it.toModel() } ?: emptyList()
fun CharacterResponse.toEntity(): CharacterEntity =
    CharacterEntity(id, name, thumbnail?.imageUrl ?: "")

fun List<CharacterResponse>?.toEntity(): List<CharacterEntity> =
    this?.map { it.toEntity() } ?: emptyList()