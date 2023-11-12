package com.example.mrsuapp.api.mrsu

import com.example.mrsuapp.api.mrsu.dto.MrsuToken
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException
import java.util.Date

class TokenManager constructor(private val api: MrsuApi) {
    private var mrsuToken: MrsuToken? = null
    private var expiresIn: Date? = null
    companion object {
        private var instance: TokenManager? = null

        fun getInstance(api: MrsuApi): TokenManager {
            return instance ?: synchronized(this) {
                instance ?: TokenManager(api).also { instance = it }
            }
        }
    }

    suspend fun getAccessToken(): String{
        if (!isActiveToken())  {
            mrsuToken = api.refreshToken(refreshToken = mrsuToken!!.accessToken)
        }
        return mrsuToken!!.accessToken
    }
    suspend fun initToken(username: String, password: String){
        mrsuToken = api.getToken(username = username, password = password)
        expiresIn = Date(System.currentTimeMillis() + mrsuToken!!.expiresIn * 1000)
    }
    private fun isActiveToken() : Boolean{
        return expiresIn!!.before(Date(System.currentTimeMillis()))
    }

    fun clearToken() {
        mrsuToken = null;
    }
}