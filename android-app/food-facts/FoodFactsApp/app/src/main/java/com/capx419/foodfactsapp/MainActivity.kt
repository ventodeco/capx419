package com.capx419.foodfactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capx419.foodfactsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.btnAboutUs.setOnClickListener{
            val aboutUsIntent = Intent(this@MainActivity, AboutUs::class.java)
            startActivity(aboutUsIntent)
        }
    }
}