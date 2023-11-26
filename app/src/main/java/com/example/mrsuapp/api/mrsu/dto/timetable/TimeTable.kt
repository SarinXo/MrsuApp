package com.example.mrsuapp.api.mrsu.dto.timetable

import com.google.gson.annotations.SerializedName

data class TimeTable(
    @SerializedName("Date")
    val date: String,
    @SerializedName("Lessons")
    val lessons: List<TimeTableLesson>
)