package com.example.mrsuapp.api.mrsu.dto

import com.example.mrsuapp.api.mrsu.dto.MarkZeroSession
import com.example.mrsuapp.api.mrsu.dto.Sections
import com.google.gson.annotations.SerializedName

data class StudentRatingPlan(
    @SerializedName("MarkZeroSession")
    val markZeroSession: MarkZeroSession,
    @SerializedName("Sections")
    val sections: List<Sections>
)
