package com.example.color_app_test.di

import com.example.color_app_test.domain.repository.ColorsRepository
import com.example.color_app_test.domain.usecases.GetColorsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetColorsUseCase(repository: ColorsRepository): GetColorsUseCase {
        return GetColorsUseCase(repository)
    }

}