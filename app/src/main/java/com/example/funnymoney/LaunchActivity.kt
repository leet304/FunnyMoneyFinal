package com.example.funnymoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LaunchActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch)

        Handler().postDelayed({ //Allows splash screen to stay on screen for 300ms before loading the main activity for the app
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)


    }
}