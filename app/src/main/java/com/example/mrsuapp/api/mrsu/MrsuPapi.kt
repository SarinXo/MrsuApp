package com.example.mrsuapp.api.mrsu

import com.example.mrsuapp.api.mrsu.dto.Discipline
import com.example.mrsuapp.api.mrsu.dto.users.Student
import com.example.mrsuapp.api.mrsu.dto.users.User
import com.example.mrsuapp.api.mrsu.dto.EventInfo
import com.example.mrsuapp.api.mrsu.dto.SecurityEvent
import com.example.mrsuapp.api.mrsu.dto.StudentRatingPlan
import com.example.mrsuapp.api.mrsu.dto.StudentSemester
import com.example.mrsuapp.api.mrsu.dto.timetable.StudentTimeTable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MrsuPapi {
    @GET("v1/StudentInfo")
    suspend fun getStudent(): Student

    @GET("v1/User")
    suspend fun getUser(
        @Header("Authorization") authorization: String
    ): User

    @GET("v1/StudentInfo")
    suspend fun getStudent(
        @Header("Authorization") authorization: String
    ): Student

    @GET("v1/Security")
    suspend fun getSecurityEvents(
        @Header("Authorization") authorization: String,
        @Query("date") date: String
    ): List<SecurityEvent>

    @GET("v1/Events")
    suspend fun getEventsByDate(
        @Header("Authorization") authorization: String,
        @Query("date") date: String
    ): List<EventInfo>

    @GET("v1/Events")
    suspend fun getEvents(
        @Header("Authorization") authorization: String,
    ): List<EventInfo>

    @GET("v1/Events")
    suspend fun getEventsByMode(
        @Header("Authorization") authorization: String,
        @Query("mode") mode: String
    ): List<EventInfo>

    @GET("v1/StudentTimeTable")
    suspend fun getStudentTimeTable(
        @Header("Authorization") authorization: String,
        @Query("date") date: String
    ): List<StudentTimeTable>

    @GET("v1/StudentSemester?selector=current")
    suspend fun getStudentSemester(
        @Header("Authorization") authorization: String
    ): StudentSemester

    @GET("v1/StudentSemester")
    suspend fun getStudentSemester(
        @Header("Authorization") authorization: String,
        @Query("year") year: String,
        @Query("period") period: Int): StudentSemester

    @GET("v1/StudentRatingPlan")
    suspend fun getStudentRatingPlan(
        @Header("Authorization") authorization: String,
        @Query("id") id: Int): StudentRatingPlan

    @GET("v1/Discipline")
    suspend fun getDisciplineById(
        @Header("Authorization") authorization: String,
        @Query("id") id: Int): Discipline


    companion object {
        private const val BASE_URL = "https://papi.mrsu.ru/"

        fun create(): MrsuPapi {
            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(MrsuPapi::class.java)
        }
    }
}