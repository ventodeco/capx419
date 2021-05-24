package com.capx419.foodfactsapp.utils

import android.widget.ImageButton
import com.capx419.foodfactsapp.R

fun emptyString() = ""

fun ImageButton.isFavorited(boolean: Boolean){
    if (boolean) {
        this.setImageResource(R.drawable.ic_fill_bookmark)
    }else{
        this.setImageResource(R.drawable.ic_bookmarks)
    }
}