package com.example.mrsuapp.api.mrsu.dto.timetable

import com.google.gson.annotations.SerializedName

data class TimeTableLesson(
    @SerializedName("Number")
    val number: Byte,
    @SerializedName("SubgroupCount")
    val subgroupCount: Byte,
    @SerializedName("Disciplines")
    val disciplines: List<TimeTableLessonDiscipline>
)
