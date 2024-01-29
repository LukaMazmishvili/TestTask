package com.example.color_app_test.data.remote.repository

import android.util.Log
import com.example.color_app_test.common.Resource
import com.example.color_app_test.data.remote.models.ColorModelDto
import com.example.color_app_test.data.remote.services.ColorsService
import com.example.color_app_test.domain.mappers.ColorModelMapper
import com.example.color_app_test.domain.models.ColorModel
import com.example.color_app_test.domain.repository.ColorsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ColorsRepositoryImpl @Inject constructor(private val colorsService: ColorsService) :
    ColorsRepository {

    override suspend fun fetchColors(): Flow<Resource<List<ColorModel>>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val response = colorsService.fetchColors()

                if (response.isSuccessful) {
                    val body = response.body()
                    Log.d("dateCreatedFromResponse", "fetchColors: ${body!!.map { it.dateCreated }}")
                    Log.d("dateCreatedMapped", "fetchColors: ${body!!.map { ColorModelMapper.buildFrom(it).dateCreated }}")
                    emit(Resource.Success(body!!.map { ColorModelMapper.buildFrom(it)  }))
                } else {
                    emit(Resource.Error(response.errorBody()?.string() ?: "Unknown error occurred"))
                }

                emit(Resource.Loading(false))

            } catch (e: Exception) {
                emit(Resource.Error("Something Went Wrong : ${e.message}"))
            }
        }

//    override suspend fun fetchColors(): Resource<List<ColorModelDto>> {
//        return try {
//
//            Resource.Loading(true)
//
//            val response = colorsService.fetchColors()
//
//            if (response.isSuccessful) {
//                val body = response.body()
//                Resource.Success(body!!)
//            } else {
//                Resource.Error(response.errorBody()?.string() ?: "Unknown error occurred")
//            }
//
//        } catch (e: Exception) {
//            Resource.Error("Something Went Wrong : ${e.message}")
//        } finally {
//            //Hide Loading State
//            // todo აქ რო აfals-ებ - ვინ აღიქვამს ამის false-ობას
//            // კოდში რა დაგილას მომივა აქ რო false-ს დასვამ
//            Resource.Loading(false)
//        }
//    }

    }
}