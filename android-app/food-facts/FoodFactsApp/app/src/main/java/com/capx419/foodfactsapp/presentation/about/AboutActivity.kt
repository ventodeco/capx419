package com.capx419.foodfactsapp.presentation.about

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.capx419.foodfactsapp.databinding.ActivityAboutBinding
import com.capx419.foodfactsapp.utils.emptyString

class AboutActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, AboutActivity::class.java))
        }
    }

    private lateinit var aboutBinding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        aboutBinding = ActivityAboutBinding.inflate(layoutInflater)

        setContentView(aboutBinding.root)

        setSupportActionBar(aboutBinding.toolbarAbout.toolbar)
        supportActionBar?.title = emptyString()
        supportActionBar?.setDisplayShowHomeEnabled(true)
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