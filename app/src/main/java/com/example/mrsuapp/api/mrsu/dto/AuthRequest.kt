package com.example.loginapp.activity.logic.auth.retrofit.dto

import com.google.gson.annotations.SerializedName

data class AuthRequest(
   @SerializedName("grant_type")
   val grantType: String,
   @SerializedName("username")
   val username: String,
   @SerializedName("password")
   val password: String,
   @SerializedName("client_id")
   val clientId: String,
   @SerializedName("client_secret")
   val clientSecret: String
)
