package com.example.color_app_test.domain.usecases

import com.example.color_app_test.domain.repository.ColorsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetColorsUseCase @Inject constructor(private val repository: ColorsRepository) {

    suspend operator fun invoke() = flow {
        repository.fetchColors().collect {
            emit(it)
        }
    }

}