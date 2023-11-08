package com.example.loginapp.activity.logic.auth.retrofit.api

import com.example.loginapp.activity.logic.auth.retrofit.dto.Student
import retrofit2.http.GET

interface MrsuPapi {
    @GET("v1/StudentInfo")
    suspend fun getStudent(): Student
}