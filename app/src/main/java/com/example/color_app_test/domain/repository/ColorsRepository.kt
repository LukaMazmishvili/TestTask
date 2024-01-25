package com.example.color_app_test.domain.repository

import com.example.color_app_test.common.Resource
import com.example.color_app_test.data.remote.models.ColorModelDto
import kotlinx.coroutines.flow.Flow

interface ColorsRepository {

    suspend fun fetchColors(): Flow<Resource<List<ColorModelDto>>>
//    suspend fun fetchColors(): Resource<List<ColorModelDto>>

}