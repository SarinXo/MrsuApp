package com.example.mrsuapp.api.mrsu

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpClient {
    val mrsuApi: MrsuApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://p.mrsu.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(MrsuApi::class.java)
    }

    val mrsuPapi: MrsuPapi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://p.mrsu.papi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(MrsuPapi::class.java)
    }

    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request())
            }
            .build()
    }

}