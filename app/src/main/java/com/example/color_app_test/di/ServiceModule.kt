package com.example.color_app_test.di

import com.example.color_app_test.data.remote.services.ColorsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideColorsService(retrofit: Retrofit) : ColorsService {
        return retrofit.create(ColorsService::class.java)
    }
}