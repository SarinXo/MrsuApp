package com.example.mrsuapp.api.mrsu.dto

import com.example.mrsuapp.api.mrsu.dto.timetable.UserCrop
import com.google.gson.annotations.SerializedName

data class TestProfiles(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("TestTitle")
    val testTitle: String,
    @SerializedName("Creator")
    val creator: UserCrop
)
