package com.amarinag.marvelapi.data.network.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("offset")
    val offset: Int?, // 0
    @SerializedName("limit")
    val limit: Int?, // 20
    @SerializedName("total")
    val total: Int?, // 1559
    @SerializedName("count")
    val count: Int?, // 20
    @SerializedName("results")
    val results: List<CharacterResponse>
)