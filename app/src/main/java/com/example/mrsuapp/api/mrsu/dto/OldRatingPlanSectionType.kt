package com.example.mrsuapp.api.mrsu.dto

import com.google.gson.annotations.SerializedName

enum class OldRatingPlanSectionType {
    @SerializedName("Экзамен")
    EXAM,
    @SerializedName("Текущий")
    DEFAULT,
    @SerializedName("Курсовая")
    PROJECT
}
