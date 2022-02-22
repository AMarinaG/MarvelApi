package com.amarinag.marvelapi.data.network.model


import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("type")
    val type: String?, // detail
    @SerializedName("url")
    val url: String? // http://marvel.com/characters/74/3-d_man?utm_campaign=apiRef&utm_source=bfe7efae41943b9b5d33e03e3b0d9c1d
)