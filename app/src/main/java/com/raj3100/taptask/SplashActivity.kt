package com.raj3100.taptask

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity

class SplashActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        val editor = getSharedPreferences("user_data", MODE_PRIVATE)
        val userName = editor.getString("userID", null);



        Handler().postDelayed({
            var intent = Intent(this, MainActivity::class.java)
            if(userName == null)
             intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}