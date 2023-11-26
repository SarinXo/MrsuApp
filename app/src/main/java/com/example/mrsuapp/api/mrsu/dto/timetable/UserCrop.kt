package com.example.mrsuapp.api.mrsu.dto.timetable

import com.example.mrsuapp.api.mrsu.dto.users.UserPhoto
import com.google.gson.annotations.SerializedName

data class UserCrop(
    @SerializedName("Id")
    val id: String,
    @SerializedName("UserName")
    val userName: String,
    @SerializedName("FIO")
    val fio: String,
    @SerializedName("Photo")
    val photo: UserPhoto
)
