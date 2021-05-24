package com.capx419.foodfactsapp.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capx419.foodfactsapp.databinding.ActivityMainBinding
import com.capx419.foodfactsapp.presentation.about.AboutActivity
import com.capx419.foodfactsapp.presentation.history.HistoryActivity
import com.capx419.foodfactsapp.presentation.openimage.OpenImageActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        mainBinding.btnHowToUse.setOnClickListener {
            Toast.makeText(this, "In Development", Toast.LENGTH_SHORT).show()
        }

        mainBinding.btnAboutUs.setOnClickListener {
            AboutActivity.start(this)
        }
        mainBinding.btnAddImage.setOnClickListener {
            OpenImageActivity.start(this)
        }
        mainBinding.btnHistory.setOnClickListener {
            HistoryActivity.start(this)
        }
    }
}