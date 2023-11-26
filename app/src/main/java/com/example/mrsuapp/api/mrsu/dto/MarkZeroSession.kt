package com.example.mrsuapp.api.mrsu.dto

import com.google.gson.annotations.SerializedName

data class MarkZeroSession(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Ball")
    val ball: Double,
    @SerializedName("CreatorId")
    val creatorId: String,
    @SerializedName("CreateDate")
    val createDate: String
)
