package com.example.color_app_test.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale


fun String.formatDate() : String {

    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("HH:mm-dd/MM", Locale.getDefault())

    return try {
        val date = inputFormat.parse(this)
        val formattedDate = outputFormat.format(date!!)


        formattedDate
    } catch (e: ParseException) {
        "${e.printStackTrace()}"
    }
}