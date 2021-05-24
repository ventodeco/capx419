package com.capx419.foodfactsapp.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capx419.foodfactsapp.databinding.ActivityMainBinding
import com.capx419.foodfactsapp.presentation.about.AboutActivity
import com.capx419.foodfactsapp.presentation.history.HistoryActivity
import com.capx419.foodfactsapp.presentation.howtouse.HowToUseFragment
import com.capx419.foodfactsapp.presentation.openimage.OpenImageActivity
import com.capx419.foodfactsapp.utils.Const.CUSTOM_FRAGMENT

class MainActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        mainBinding.btnHowToUse.setOnClickListener {
            HowToUseFragment().show(supportFragmentManager, CUSTOM_FRAGMENT)
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