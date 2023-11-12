package com.example.mrsuapp.api.mrsu

import com.example.mrsuapp.api.mrsu.dto.MrsuToken
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

class TokenManager(private val api: MrsuApi) {
    private var mrsuToken: MrsuToken? = null

    suspend fun getAccessToken(username: String, password: String): String {
        if (mrsuToken == null) {
            mrsuToken = api.getToken(username = username, password = password)
        }
/*
        else if(){
            mrsuToken = refreshToken()
        }*/
        return mrsuToken!!.accessToken
    }

    private suspend fun refreshToken(): MrsuToken = withContext(Dispatchers.IO) {

        val formBody: RequestBody = FormBody.Builder()
            .add("grant_type", "refresh_token")
            .add("client_id", "8")
            .add("client_secret", "qweasd")
            .add("refresh_token", mrsuToken!!.refreshToken)
            .build()

        val request: Request = Request.Builder()
            .url("/OAuth/Token")
            .post(formBody)
            .build()

        try {
            val response = HttpClient.okHttpClient.newCall(request).execute()
            if (response.isSuccessful) {
                val json = response.body?.string()
                json?.let {
                    return@withContext Gson().fromJson(it, MrsuToken::class.java)
                } ?: throw IOException("Empty or null response body")
            } else {
                throw IOException("Error refreshing token: ${response.code}")
            }
        } catch (e: IOException) {
            throw e
        }
    }

    fun clearToken() {
        mrsuToken = null;
    }
}