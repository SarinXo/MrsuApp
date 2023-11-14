package com.example.mrsuapp.api.mrsu

import com.example.mrsuapp.api.mrsu.dto.MrsuToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date

class TokenManager{
    companion object {
        private const val BASE_URL = "https://p.mrsu.ru/"
        private var mrsuToken: MrsuToken? = null
        private var expiresIn: Date? = null
        private var api: MrsuApi

        init {
            api = create()
        }

        private fun create(): MrsuApi {
            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                    request.addHeader("Authorization", "Basic ODpxd2Vhc2Q=")
                    chain.proceed(request.build())
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
    suspend fun authenticate(username: String, password: String): String?{
        return try {
            mrsuToken = api.getToken(username = username, password = password)
            expiresIn = Date(System.currentTimeMillis() + mrsuToken!!.expiresIn * 1000)
            mrsuToken!!.accessToken
        } catch (e: Exception) {
            null
        }
    }
    suspend fun getToken(): String?{
        return try {
            refreshToken()
            mrsuToken!!.accessToken
        } catch (e: Exception) {
            null
        }
    }

    private suspend fun refreshToken(){
        if (!isActiveToken()) {
            api.refreshToken(refreshToken = mrsuToken!!.accessToken)
        }
    }

    private fun isActiveToken(): Boolean{
        return expiresIn!!.before(Date(System.currentTimeMillis()))
    }

    fun clearToken() {
        mrsuToken = null;
    }
}