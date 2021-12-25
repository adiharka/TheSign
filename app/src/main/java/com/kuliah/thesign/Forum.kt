package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import com.kuliah.thesign.adapter.ForumListAdapter
import com.kuliah.thesign.database.DatabaseHandler
import com.kuliah.thesign.model.ForumModelClass
import kotlinx.android.synthetic.main.forum_list.*

class Forum : AppCompatActivity() {

    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

        //creating the instance of DatabaseHandler class
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        //calling the viewEmployee method of DatabaseHandler class to read the records
        val emp: List<ForumModelClass> = databaseHandler.getForum()

        listView = findViewById(R.id.forum_listview)
        listView.adapter = ForumListAdapter(this,R.layout.forum_list,emp)
        Log.d("CREATION", "Bikin listview")

        listView.setOnItemClickListener{parent, view, position, id ->
            val forum_id = view.findViewById(R.id.forum_id) as TextView
            val username = view.findViewById(R.id.username) as TextView
            val topic = view.findViewById(R.id.topic) as TextView
            val content = view.findViewById(R.id.content) as TextView
//            Log.d("CREATION", forum_id)
            val intent = Intent(this, ForumDetail::class.java)
            intent.putExtra("forum_id",forum_id.text.toString());
            intent.putExtra("username",username.text.toString());
            intent.putExtra("topic",topic.text.toString());
            intent.putExtra("content",content.text.toString());
            startActivity(intent)
         }
//
//        val forumBtn = findViewById<TextView>(R.id.count)
//        forumBtn.setOnClickListener {
//            val intent = Intent(this, ForumDetail::class.java)
//            startActivity(intent)
//        }
        val ctaBtn = findViewById<ImageButton>(R.id.ctaBtn)
        ctaBtn.setOnClickListener {
            val intent = Intent(this, ForumCreate::class.java)
            startActivity(intent)
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
    override fun onRestart() {
        super.onRestart()
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)

        val emp: List<ForumModelClass> = databaseHandler.getForum()

        listView = findViewById(R.id.forum_listview)
        listView.adapter = ForumListAdapter(this,R.layout.forum_list,emp)
        Log.d("CREATION", "Bikin listview")
    }
}