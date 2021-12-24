package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.kuliah.thesign.database.DatabaseHandler

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val databaseHandler = DatabaseHandler(this)
        val email = findViewById<EditText>(R.id.emailForm)
        val password = findViewById<EditText>(R.id.passForm)
        val uname = findViewById<EditText>(R.id.unameForm)

        val register = findViewById<ImageButton>(R.id.signupBtn)
        register.setOnClickListener {
            val status = databaseHandler.createAccount(email.text.toString(), password.text.toString(), uname.text.toString())
            Log.d("CREATION", "Create account mail,pass,uname - " + email.text.toString() + password.text.toString() + uname.text.toString())
            if (status) {
                Toast.makeText(getApplicationContext(), "Sukses mendaftar", Toast.LENGTH_LONG).show();
                finish()
            } else {
                Toast.makeText(getApplicationContext(), "Username/email sudah dipakai", Toast.LENGTH_LONG).show();
            }
        }

        val loginBtn = findViewById<TextView>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            finish()
        }
    }
}