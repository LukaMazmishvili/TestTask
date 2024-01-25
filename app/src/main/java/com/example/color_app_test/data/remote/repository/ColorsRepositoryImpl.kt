package com.example.color_app_test.data.remote.repository

import com.example.color_app_test.common.Resource
import com.example.color_app_test.data.remote.models.ColorModel
import com.example.color_app_test.data.remote.services.ColorsService
import com.example.color_app_test.domain.repository.ColorsRepository
import retrofit2.Response
import javax.inject.Inject

class ColorsRepositoryImpl @Inject constructor(private val colorsService: ColorsService) :
    ColorsRepository {

    override suspend fun fetchColors(): Resource<List<ColorModel>> {
        return try {

            Resource.Loading(true)

            val response = colorsService.fetchColors()

            if (response.isSuccessful) {
                val body = response.body()
                Resource.Success(body!!)
            } else {
                Resource.Error(response.errorBody()?.string() ?: "Unknown error occurred")
            }

        } catch (e: Exception) {
            Resource.Error("Something Went Wrong : ${e.message}")
        } finally {
            //Hide Loading State
            // todo აქ რო აfals-ებ - ვინ აღიქვამს ამის false-ობას
            // კოდში რა დაგილას მომივა აქ რო false-ს დასვამ
            Resource.Loading(false)
        }
    }

}