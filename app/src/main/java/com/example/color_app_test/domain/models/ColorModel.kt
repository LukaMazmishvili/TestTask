package com.example.color_app_test.domain.models

import android.os.Parcelable
import com.example.color_app_test.data.remote.models.RGB
import kotlinx.parcelize.Parcelize

@Parcelize
data class ColorModel(
    val id: Long,
    val title: String,
    val userName: String,
    val dateCreated: String,
    val rgb: RGB,
    val description: String,
    val imageUrl: String
) : Parcelable
