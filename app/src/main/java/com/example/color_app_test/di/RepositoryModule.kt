package com.example.color_app_test.di

import com.example.color_app_test.data.remote.repository.ColorsRepositoryImpl
import com.example.color_app_test.data.remote.services.ColorsService
import com.example.color_app_test.domain.repository.ColorsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideColorsRepository(colorService: ColorsService) : ColorsRepository{
        return ColorsRepositoryImpl(colorService)
    }
}