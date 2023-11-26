package com.example.mrsuapp.api.mrsu.dto

import com.google.gson.annotations.SerializedName

data class DocFiles(
    @SerializedName("Id")
    val id: String,
    @SerializedName("CreatorId")
    val creatorId: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("FileName")
    val fileName: String,
    @SerializedName("MIMEtype")
    val mimetype: String,
    @SerializedName("Size")
    val size: Int,
    @SerializedName("Date")
    val date: String,
    @SerializedName("URL")
    val url: String
)
