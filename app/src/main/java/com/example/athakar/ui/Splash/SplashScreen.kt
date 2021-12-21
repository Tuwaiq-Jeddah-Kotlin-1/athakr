package com.example.athakar.ui.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.athakar.ui.main.activity.MainActivity
import com.example.athakar.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            //code
            startActivity(Intent(this, MainActivity::class.java))
        }, 2000)

    }
}