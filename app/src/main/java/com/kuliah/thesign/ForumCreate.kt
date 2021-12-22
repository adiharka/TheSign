package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ForumCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum_create)


        val categoryBtn = findViewById<ImageButton>(R.id.category)
        categoryBtn.setOnClickListener {
            val intent = Intent(this, Category::class.java)
            startActivity(intent)
            finish()
        }
        val homeBtn = findViewById<ImageButton>(R.id.home)
        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val accountBtn = findViewById<ImageButton>(R.id.account)
        accountBtn.setOnClickListener {
            val intent = Intent(this, Account::class.java)
            startActivity(intent)
            finish()
        }
    }
}