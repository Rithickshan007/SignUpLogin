package com.example.signuplogin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val editNewUsername = findViewById<EditText>(R.id.editNewUsername)
        val editNewPassword = findViewById<EditText>(R.id.editNewPassword)
        val btnSignup = findViewById<Button>(R.id.btnSignup)
        val tvAlreadyRegistered = findViewById<TextView>(R.id.tvAlreadyRegistered)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        btnSignup.setOnClickListener {
            val newUsername = editNewUsername.text.toString()
            val newPassword = editNewPassword.text.toString()

            if (newUsername.isNotEmpty() && newPassword.isNotEmpty()) {
                val editor = sharedPreferences.edit()
                editor.putString("USERNAME", newUsername)
                editor.putString("PASSWORD", newPassword)
                editor.apply()

                Toast.makeText(this, "Signup Successful! Please Login.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please enter all fields!", Toast.LENGTH_SHORT).show()
            }
        }

        tvAlreadyRegistered.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
