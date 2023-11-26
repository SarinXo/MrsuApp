package com.example.mrsuapp.api.mrsu.dto

import com.google.gson.annotations.SerializedName

data class SecurityEvent(
    @SerializedName("Build")
    val build: String,
    @SerializedName("Time")
    val time: String,
    @SerializedName("Status")
    val status: String
)