package com.example.mrsuapp.api.mrsu.dto.users

import com.google.gson.annotations.SerializedName

data class UserPhoto(
    @SerializedName("UrlSmall")
    val urlSmall: String,
    @SerializedName("UrlMedium")
    val urlMedium: String,
    @SerializedName("UrlSource")
    val urlSource: String
)
