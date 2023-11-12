package com.example.mrsuapp.api.mrsu.dto

import com.google.gson.annotations.SerializedName

data class MrsuToken(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: Int,
    @SerializedName("refresh_token")
    val refreshToken: String
)
