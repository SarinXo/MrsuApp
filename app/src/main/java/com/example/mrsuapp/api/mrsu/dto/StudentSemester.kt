package com.example.mrsuapp.api.mrsu.dto

import com.google.gson.annotations.SerializedName

data class StudentSemester(
    @SerializedName("RecordBooks")
    val recordBooks: List<RecordBooksStudentSemester>,
    @SerializedName("UnreadedDisCount")
    val unreadedDisCount: Int,
    @SerializedName("UnreadedDisMesCount")
    val unreadedDisMesCount: Int,
    @SerializedName("Year")
    val year: String,
    @SerializedName("Period")
    val period: Int,
)
