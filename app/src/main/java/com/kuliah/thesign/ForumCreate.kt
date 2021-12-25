package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.kuliah.thesign.database.DatabaseHandler
import com.kuliah.thesign.model.ForumModelClass

class ForumCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum_create)

        var topic:String
        var content:String

        //creating the instance of DatabaseHandler class
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        val uname = databaseHandler.getUname(databaseHandler.checkAccount())


        val postBtn = findViewById<ImageButton>(R.id.postBtn)
        postBtn.setOnClickListener {
            topic = findViewById<TextView>(R.id.topic).text.toString()
            content = findViewById<TextView>(R.id.content).text.toString()
            if (topic.trim().isNotEmpty() && content.trim().isNotEmpty()) {
                if (databaseHandler.createForum(uname, topic, content)) {
                    Toast.makeText(this, "Sukses menambah forum", Toast.LENGTH_LONG).show();
                    finish()
                } else {
                    Toast.makeText(this, "Error, harap coba lagi", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Mohon isi semua kolom", Toast.LENGTH_SHORT).show();
            }

        }

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