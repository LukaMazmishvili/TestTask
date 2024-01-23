package com.example.color_app_test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.color_app_test.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}