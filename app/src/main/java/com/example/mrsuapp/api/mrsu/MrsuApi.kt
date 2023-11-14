package com.example.mrsuapp.api.mrsu

import com.example.mrsuapp.api.mrsu.dto.MrsuToken
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
                         @Field("client_id") clientId: String = "8",
                         @Field("client_secret") clientSecret: String = "qweasd",
                         @Field("username") username: String,
                         @Field("password") password: String
    ): MrsuToken
    @FormUrlEncoded
    @POST("OAuth/token")
    suspend fun refreshToken(@Field("grant_type") grantType: String = "refresh_token",
                             @Field("refresh_token") refreshToken: String
    ): MrsuToken


}