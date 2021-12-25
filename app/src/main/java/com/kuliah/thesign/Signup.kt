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
            if (email.text.toString().trim().isNotEmpty() && password.text.toString().trim().isNotEmpty() && uname.text.toString().trim().isNotEmpty()) {
                    val status = databaseHandler.createAccount(email.text.toString(), password.text.toString(), uname.text.toString())
                    Log.d("CREATION", "Create account mail,pass,uname - " + email.text.toString() + password.text.toString() + uname.text.toString())
                    if (status) {
                        Toast.makeText(this, "Sukses mendaftar", Toast.LENGTH_LONG).show();
                        finish()
                    } else {
                        Toast.makeText(this, "Username/email sudah dipakai", Toast.LENGTH_SHORT).show();
                    }
                }else {
                Toast.makeText(this, "Mohon isi semua kolom", Toast.LENGTH_SHORT).show();
            }

        }

        val loginBtn = findViewById<TextView>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            finish()
        }
    }
}