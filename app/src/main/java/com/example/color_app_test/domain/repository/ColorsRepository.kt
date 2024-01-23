package com.example.color_app_test.domain.repository

import com.example.color_app_test.common.Resource
import com.example.color_app_test.data.remote.models.ColorModel
import retrofit2.Response

interface ColorsRepository {

    suspend fun fetchColors(): Resource<List<ColorModel>>

}