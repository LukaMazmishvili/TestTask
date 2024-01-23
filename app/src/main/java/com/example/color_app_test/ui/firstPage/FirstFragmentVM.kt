package com.example.color_app_test.ui.firstPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.color_app_test.common.Resource
import com.example.color_app_test.data.remote.models.ColorModel
import com.example.color_app_test.domain.repository.ColorsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstFragmentVM @Inject constructor(private val colorsRepository: ColorsRepository) :
    ViewModel() {

    private val _getColorsState = MutableStateFlow(ArticlesApiState())
    val getColorsState = _getColorsState.asStateFlow()

    fun getColors() {
        viewModelScope.launch {
            _getColorsState.value = getColorsState.value.copy(isLoading = true)
            when (val response = colorsRepository.fetchColors()) {
                is Resource.Success -> {
                    _getColorsState.value = getColorsState.value.copy(
                        isLoading = false,
                        data = response.data,
                    )
                }

                is Resource.Error -> {
                    _getColorsState.value = _getColorsState.value.copy(
                        isLoading = false,
                        error = response.errorMsg
                    )
                }

                is Resource.Loading -> {
                    _getColorsState.value = _getColorsState.value.copy(
                        isLoading = true
                    )
                }
            }
        }

    }

    data class ArticlesApiState(
        val isLoading: Boolean = false,
        val data: List<ColorModel>? = null,
        val error: String = ""
    )

}