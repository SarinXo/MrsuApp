package com.example.mrsuapp.api.mrsu

import com.example.loginapp.activity.logic.auth.retrofit.dto.Student
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MrsuPapi {
    @GET("v1/StudentInfo")
    suspend fun getStudent(): Student

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