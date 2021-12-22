package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val bedroomBtn = findViewById<ImageButton>(R.id.bedroom)
        bedroomBtn.setOnClickListener {
            val intent = Intent(this, Design::class.java)
            intent.putExtra("category", "Bedroom")
            startActivity(intent)
        }
        val bathroomBtn = findViewById<ImageButton>(R.id.bathroom)
        bathroomBtn.setOnClickListener {
            val intent = Intent(this, Design::class.java)
            intent.putExtra("category", "Bathroom")
            startActivity(intent)
        }
        val livingBtn = findViewById<ImageButton>(R.id.livingroom)
        livingBtn.setOnClickListener {
            val intent = Intent(this, Design::class.java)
            intent.putExtra("category", "Livingroom")
            startActivity(intent)
        }
        val luxuryBtn = findViewById<ImageButton>(R.id.cat_luxury)
        luxuryBtn.setOnClickListener {
            val intent = Intent(this, Design::class.java)
            intent.putExtra("category", "Luxury")
            startActivity(intent)
        }
        val monochromeBtn = findViewById<ImageButton>(R.id.cat_monochrome)
        monochromeBtn.setOnClickListener {
            val intent = Intent(this, Design::class.java)
            intent.putExtra("category", "Monochrome")
            startActivity(intent)
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
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}