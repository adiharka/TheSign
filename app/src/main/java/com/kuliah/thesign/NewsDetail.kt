package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.text.Spanned

import android.text.style.RelativeSizeSpan

import android.text.SpannableString
import android.widget.ImageButton
import java.util.*


class NewsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val extras = intent.extras
        val imgNews = extras!!.getInt("img")
        val titleNews = extras.getString("title")
        val textNews = extras.getString("text")

        val tempStr =
            textNews!!.substring(0, 1).uppercase(Locale.getDefault()) + textNews.substring(1)

        val spannableString = SpannableString(tempStr)
        spannableString.setSpan(RelativeSizeSpan(2f), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        findViewById<ImageView>(R.id.img).setImageResource(imgNews)
        findViewById<TextView>(R.id.title).text = titleNews
        findViewById<TextView>(R.id.text).text = spannableString


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