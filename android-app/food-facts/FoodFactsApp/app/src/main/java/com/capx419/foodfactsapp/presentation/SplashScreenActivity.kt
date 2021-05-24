package com.capx419.foodfactsapp.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.capx419.foodfactsapp.R.layout
import com.capx419.foodfactsapp.presentation.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            MainActivity.start(this)
            finish()
        }, 3000)
    }
}