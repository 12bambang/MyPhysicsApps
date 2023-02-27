package com.example.myphysicsapps.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myphysicsapps.MainActivity
import com.example.myphysicsapps.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val usernameEditText: EditText = findViewById(R.id.usrname)
        val passwordEditText: EditText = findViewById(R.id.password)
        val loginButton : Button = findViewById(R.id.btnlogin)

// Set an OnClickListener on the login button
        loginButton.setOnClickListener {
            // Get the values of the username and password EditTexts
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if the username and password are correct
            if (username == "murid" && password == "murid123") {
                // If they are correct, show a toast message and start the next activity
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            } else {
                // If they are incorrect, show a toast message
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}