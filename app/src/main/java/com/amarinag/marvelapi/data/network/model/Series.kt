package com.amarinag.marvelapi.data.network.model


import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("available")
    val available: Int?, // 3
    @SerializedName("collectionURI")
    val collectionURI: String?, // http://gateway.marvel.com/v1/public/characters/1011334/series
    @SerializedName("items")
    val items: List<Item>?,
    @SerializedName("returned")
    val returned: Int? // 3
)