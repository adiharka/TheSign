package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.kuliah.thesign.adapter.ReplyListAdapter
import com.kuliah.thesign.database.DatabaseHandler
import com.kuliah.thesign.model.ReplyModelClass

class ForumDetail : AppCompatActivity() {

    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum_detail)

        listView = findViewById(R.id.reply_listview)

//        val forum_id: String?
        val forum_id: String? = intent.extras?.getString("forum_id")
        val username: String? = intent.extras?.getString("username")
        val topic: String? = intent.extras?.getString("topic")
        val content: String? = intent.extras?.getString("content")

        findViewById<TextView>(R.id.username).text = username
        findViewById<TextView>(R.id.topic).text = topic
        findViewById<TextView>(R.id.content).text = content

        //creating the instance of DatabaseHandler class
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        val uname = databaseHandler.getUname(databaseHandler.checkAccount())

        //calling the getReply method of DatabaseHandler class to read the records
        var emp: List<ReplyModelClass> = databaseHandler.getReply(forum_id!!.toInt())
        listView.adapter = ReplyListAdapter(this, R.layout.reply_list, emp)

        val replyBtn = findViewById<ImageButton>(R.id.replyBtn)
        replyBtn.setOnClickListener {
            val replyText = findViewById<TextView>(R.id.replyText).text.toString()
            if (replyText.trim().isNotEmpty()) {
                if (databaseHandler.createReply(forum_id.toInt(), uname, replyText)) {
                    Toast.makeText(this, "Sukses menambah komentar", Toast.LENGTH_SHORT).show();
                    emp = databaseHandler.getReply(forum_id.toInt())
                    listView.adapter = ReplyListAdapter(this, R.layout.reply_list, emp)
                    findViewById<TextView>(R.id.replyText).text = ""
                } else {
                    Toast.makeText(this, "Error, harap coba lagi", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Mohon isi kolom reply", Toast.LENGTH_SHORT).show();
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