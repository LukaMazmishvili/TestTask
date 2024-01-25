package com.example.color_app_test.data.remote.services

import com.example.color_app_test.common.Endpoints.COLORS_ENDPOINT
import com.example.color_app_test.data.remote.models.ColorModelDto
import retrofit2.Response
import retrofit2.http.GET

interface ColorsService {

    @GET(COLORS_ENDPOINT)
    suspend fun fetchColors(): Response<List<ColorModelDto>>
}