package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.kuliah.thesign.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val databaseHandler = DatabaseHandler(this)

        val signupBtn = findViewById<TextView>(R.id.signupBtn)
        signupBtn.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

        val uname = findViewById<EditText>(R.id.emailForm)
        val password = findViewById<EditText>(R.id.passForm)

        val login = findViewById<ImageButton>(R.id.loginBtn)
        login.setOnClickListener {
            val status = databaseHandler.loginAccount(uname.text.toString(), password.text.toString())
            if (status) {
                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(getApplicationContext(), "Sukses login", Toast.LENGTH_LONG).show();
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(getApplicationContext(), "Pastikan username dan password anda benar", Toast.LENGTH_LONG).show();
            }
        }

    }
    override fun onBackPressed() {
        finish()
    }
}