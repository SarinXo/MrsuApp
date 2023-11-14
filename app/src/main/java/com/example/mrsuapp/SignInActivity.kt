package com.example.mrsuapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mrsuapp.api.mrsu.MrsuApi
import com.example.mrsuapp.api.mrsu.TokenManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin)

        val loginButton: Button = findViewById(R.id.login_button)
        val loginEditText: EditText = findViewById(R.id.login)
        val passwordEditText: EditText = findViewById(R.id.password)

        loginButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()
            authentication(login, password)

        }
    }

    private fun authentication(login : String, password : String){
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val accessToken = withContext(Dispatchers.IO) {
                    val tokenManager = TokenManager()
                    tokenManager.authenticate(login, password)
                }
                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@SignInActivity, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }


}