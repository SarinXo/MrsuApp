package com.example.mrsuapp.api.mrsu

import com.example.mrsuapp.api.mrsu.dto.auth.MrsuToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MrsuApi {

    @FormUrlEncoded
    @POST("OAuth/token")
    suspend fun getToken(@Field("grant_type") grantType: String = "password",
                         @Field("username") username: String,
                         @Field("password") password: String) : MrsuToken
    @FormUrlEncoded
    @POST("OAuth/token")
    suspend fun refreshToken(@Field("grant_type") grantType: String = "refresh_token",
                             @Field("refresh_token") refreshToken: String) : MrsuToken

    companion object {
        private const val BASE_URL = "https://p.mrsu.ru/"

        fun create(): MrsuApi {
            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("Authorization", "Basic ODpxd2Vhc2Q=")
                        .build()
                    chain.proceed(request)
                }
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(MrsuApi::class.java)
        }
    }
}