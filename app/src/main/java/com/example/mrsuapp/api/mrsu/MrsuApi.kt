package com.example.loginapp.activity.logic.auth.retrofit.api

import com.example.loginapp.activity.logic.auth.retrofit.dto.MrsuToken
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MrsuApi {

    @FormUrlEncoded
    @POST("OAuth/token")
    suspend fun getToken(@Field("grant_type") grantType: String = "password",
                         @Field("username") username: String,
                         @Field("password") password: String,
                         @Field("client_id") clientId: String = "8",
                         @Field("client_secret") clientSecret: String = "qweasd") : MrsuToken
}