package com.example.color_app_test.ui.secondPage

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.color_app_test.R
import com.example.color_app_test.common.base.BaseFragment
import com.example.color_app_test.databinding.FragmentSecondBinding
import com.example.color_app_test.extensions.formatDate
import com.example.color_app_test.extensions.formatLink
import com.example.color_app_test.extensions.uploadImageByUrl

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    private val args: SecondFragmentArgs by navArgs()

    override fun started() {
        updateUi()
    }

    override fun listeners() {

    }

    private fun updateUi() {
        val color = args.colorModel
        with(binding) {
            Glide.with(ivColorImage).load("http://www.colourlovers.com/img/9ADE74/100/100/Soft_Green.jpg").into(ivColorImage)
            Log.d("CheckIfImageCaught", "updateUi: ${color.imageUrl}")
//            ivColorImage.uploadImageByUrl(color.imageUrl)
            tvAuthor.text = color.userName
            tvTitle.text = color.title
            tvDate.text = color.dateCreated.formatDate()
            tvRGBColor.text = color.title
            tvRGBColor.setBackgroundColor(Color.rgb(color.rgb.red, color.rgb.green, color.rgb.blue))
        }
    }

}