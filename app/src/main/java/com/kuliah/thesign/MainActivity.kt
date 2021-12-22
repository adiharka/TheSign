package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forumBtn = findViewById<ImageButton>(R.id.forum)
        forumBtn.setOnClickListener {
            val intent = Intent(this, Forum::class.java)
            startActivity(intent)
        }
        val designBtn = findViewById<ImageButton>(R.id.design)
        designBtn.setOnClickListener {
            val intent = Intent(this, Design::class.java)
            startActivity(intent)
        }
        val newsBtn = findViewById<ImageButton>(R.id.news)
        newsBtn.setOnClickListener {
            val intent = Intent(this, News::class.java)
            startActivity(intent)
        }

        val categoryBtn = findViewById<ImageButton>(R.id.category)
        categoryBtn.setOnClickListener {
            val intent = Intent(this, Category::class.java)
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
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}