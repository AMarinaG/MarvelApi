package com.amarinag.marvelapi.data.network.model


import com.google.gson.annotations.SerializedName

data class MarvelApiResponse(
    @SerializedName("code")
    val code: Int?, // 200
    @SerializedName("status")
    val status: String?, // Ok
    @SerializedName("copyright")
    val copyright: String?, // © 2022 MARVEL
    @SerializedName("attributionText")
    val attributionText: String?, // Data provided by Marvel. © 2022 MARVEL
    @SerializedName("attributionHTML")
    val attributionHTML: String?, // <a href="http://marvel.com">Data provided by Marvel. © 2022 MARVEL</a>
    @SerializedName("etag")
    val etag: String?, // 37717467987c465eafb9b20233aef6bac47ffc6f
    @SerializedName("data")
    val data: Data?
)