package com.capx419.foodfactsapp.presentation.openimage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.capx419.foodfactsapp.databinding.ActivityOpenImageBinding
import com.capx419.foodfactsapp.utils.emptyString

class OpenImageActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, OpenImageActivity::class.java))
        }
    }

    private lateinit var openImageBinding: ActivityOpenImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        openImageBinding = ActivityOpenImageBinding.inflate(layoutInflater)

        setContentView(openImageBinding.root)

        setSupportActionBar(openImageBinding.toolbarOpenImage.toolbar)
        supportActionBar?.title = emptyString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        openImageBinding.btnCamera.setOnClickListener {

        }

        openImageBinding.btnGallery.setOnClickListener {

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}