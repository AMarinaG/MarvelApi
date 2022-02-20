package com.amarinag.marvelapi.data.network.response


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("resourceURI")
    val resourceURI: String?, // http://gateway.marvel.com/v1/public/comics/21366
    @SerializedName("name")
    val name: String?, // Avengers: The Initiative (2007) #14
    @SerializedName("type")
    val type: String?
)