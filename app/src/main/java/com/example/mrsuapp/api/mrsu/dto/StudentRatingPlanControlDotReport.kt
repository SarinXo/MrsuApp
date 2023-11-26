package com.example.mrsuapp.api.mrsu.dto

import com.example.mrsuapp.api.mrsu.dto.DocFiles
import com.google.gson.annotations.SerializedName

data class StudentRatingPlanControlDotReport(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("CreateDate")
    val createDate: String,
    @SerializedName("DocFiles")
    val docFiles: List<DocFiles>
)
