package com.raj3100.taptask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val phone = findViewById<EditText>(R.id.phoneNo)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {
            if(phone.text.toString().equals("1234")) {
                val editor = getSharedPreferences("user_data", MODE_PRIVATE).edit()
                editor.putString("userID", "1")
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


    }
}