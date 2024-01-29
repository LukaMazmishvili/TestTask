package com.example.color_app_test.ui.secondPage

import android.graphics.Color
import android.util.Log
import androidx.navigation.fragment.navArgs
import com.example.color_app_test.common.base.BaseFragment
import com.example.color_app_test.databinding.FragmentSecondBinding
import com.example.color_app_test.extensions.uploadImageByUrl
import kotlin.math.log

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    private val args: SecondFragmentArgs by navArgs()

    override fun started() {
        updateUi()
    }

    override fun listeners() {

    }

    private fun updateUi() {
        val color = args.colorModel

        Log.d("ColorInSecondFragment", "updateUi: $color")

        with(binding) {
            ivColorImage.uploadImageByUrl(color.imageUrl)
            tvAuthor.text = color.userName
            tvTitle.text = color.title
            tvDate.text = color.dateCreated
            tvRGBColor.text = color.title
            tvRGBColor.setBackgroundColor(Color.rgb(color.rgb.red, color.rgb.green, color.rgb.blue))
        }
    }

}