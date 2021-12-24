package com.kuliah.thesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.graphics.alpha
import com.kuliah.thesign.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val databaseHandler = DatabaseHandler(this)
        val akun:Int = databaseHandler.checkAccount()

        logo.animate().setDuration(1500).alpha(1f).withEndAction {
            var intent: Intent
            if (akun >= 0) {
                intent = Intent(this, MainActivity::class.java)
                intent.putExtra("akun_id",akun);
                Log.d("CREATION", "Login logged id:$akun")
            } else {
                intent = Intent(this, Login::class.java)
            }
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}