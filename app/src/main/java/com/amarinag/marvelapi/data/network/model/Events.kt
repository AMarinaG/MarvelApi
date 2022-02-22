package com.amarinag.marvelapi.data.network.model


import com.google.gson.annotations.SerializedName

data class Events(
    @SerializedName("available")
    val available: Int?, // 1
    @SerializedName("collectionURI")
    val collectionURI: String?, // http://gateway.marvel.com/v1/public/characters/1011334/events
    @SerializedName("items")
    val items: List<Item>?,
    @SerializedName("returned")
    val returned: Int? // 1
)