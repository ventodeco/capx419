package com.capx419.foodfactsapp.presentation.openimage

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capx419.foodfactsapp.databinding.ActivityOpenImageBinding
import com.capx419.foodfactsapp.utils.emptyString
import com.esafirm.imagepicker.features.ImagePicker
import com.esafirm.imagepicker.features.IpCons

class OpenImageActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, OpenImageActivity::class.java))
        }
    }

    private lateinit var openImageBinding: ActivityOpenImageBinding

    private var image = emptyString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        openImageBinding = ActivityOpenImageBinding.inflate(layoutInflater)

        setContentView(openImageBinding.root)

        setSupportActionBar(openImageBinding.toolbarOpenImage.toolbar)
        supportActionBar?.title = emptyString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        openImageBinding.btnCamera.setOnClickListener {
            openCamera()
        }

        openImageBinding.btnGallery.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        ImagePicker.create(this)
            .single()
            .folderMode(true)
            .start()
    }

    private fun openCamera() {
        ImagePicker.cameraOnly().start(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IpCons.RC_IMAGE_PICKER && data != null) {
            image = ImagePicker.getImages(data)[0].path
            Toast.makeText(this, image, Toast.LENGTH_LONG).show()
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
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