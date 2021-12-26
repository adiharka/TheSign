package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import com.kuliah.thesign.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_account.*

class Account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val databaseHandler = DatabaseHandler(this)
        val akun_id = databaseHandler.checkAccount()
        Log.d("CREATION", "Account logged id:$akun_id")
        findViewById<TextView>(R.id.username).text = databaseHandler.getUname(akun_id)

        val favouriteBtn = findViewById<TextView>(R.id.favouriteBtn)
        favouriteBtn.setOnClickListener {
            val intent = Intent(this, Design::class.java)
            intent.putStringArrayListExtra("favourite", databaseHandler.getFavourite(akun_id))
            startActivity(intent)
        }
        val contactBtn = findViewById<TextView>(R.id.contactBtn)
        contactBtn.setOnClickListener {
            val intent = Intent(this, ContactSupport::class.java)
            startActivity(intent)
        }
        val logoutBtn = findViewById<ImageButton>(R.id.logoutBtn)
        logoutBtn.setOnClickListener {
            databaseHandler.logoutAccount(akun_id)
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
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
    }
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}