package com.example.mrsuapp.api.mrsu.dto

import com.google.gson.annotations.SerializedName

data class RatingMark(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Ball")
    val ball: Double,
    @SerializedName("CreatorId")
    val creatorId: String,
    @SerializedName("CreateDate")
    val createDate: String
)
