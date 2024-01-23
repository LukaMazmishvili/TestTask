package com.example.color_app_test.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.uploadImageByUrl(url: String) {
    Glide.with(this).load(url).into(this)
}