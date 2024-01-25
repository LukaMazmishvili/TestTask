package com.example.color_app_test.common

sealed class Resource<T> {
    data class Success<T>(val data: T?) : Resource<T>() // todo data nullable
    data class Error<T>(val errorMsg: String) : Resource<T>()
    data class Loading<T>(val isLoading: Boolean) : Resource<T>()
}