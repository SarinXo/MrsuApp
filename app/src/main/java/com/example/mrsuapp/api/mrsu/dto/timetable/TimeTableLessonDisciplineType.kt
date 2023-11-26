package com.example.mrsuapp.api.mrsu.dto.timetable

import com.google.gson.annotations.SerializedName

enum class TimeTableLessonDisciplineType {
    @SerializedName("Default")
    DEFAULT,
    @SerializedName("Consultation")
    CONSULTATION,
    @SerializedName("Offset")
    OFFSET,
    @SerializedName("Exam")
    EXAM
}
