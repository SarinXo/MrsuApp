package com.example.mrsuapp.api.mrsu.dto

import com.google.gson.annotations.SerializedName

data class RecordBooksStudentSemester(
    @SerializedName("Cod")
    val cod: String,
    @SerializedName("Number")
    val number: String,
    @SerializedName("Faculty")
    val faculty: String,
    @SerializedName("Disciplines")
    val discipline: List<Discipline>
)
