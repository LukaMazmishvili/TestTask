package com.example.color_app_test.ui.firstPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.color_app_test.common.Resource
import com.example.color_app_test.data.remote.models.ColorModelDto
import com.example.color_app_test.domain.models.ColorModel
import com.example.color_app_test.domain.repository.ColorsRepository
import com.example.color_app_test.domain.usecases.GetColorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstFragmentVM @Inject constructor(private val getColorsUseCase: GetColorsUseCase) :
    ViewModel() {

    private val _getColorsState = MutableStateFlow(ArticlesApiState())
    val getColorsState = _getColorsState.asStateFlow()

    init {

        getColors()

    }

    // todo - domain მოდელებიც აღწერე და შესაბამისი მეფერები
    // todo - usecases
    private fun getColors() {
        // todo ეკრანის გადმოტრიალებისას ისევ იძახებს სერვისს
        viewModelScope.launch {
            getColorsUseCase.invoke().collect { response ->
                when (response) {
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
                        // todo loading state არ მოდის
                        _getColorsState.value = _getColorsState.value.copy(
                            isLoading = response.isLoading
                        )
                    }
                }
            }
        }
    }

    data class ArticlesApiState(
        val isLoading: Boolean = true,
        val data: List<ColorModel>? = null,
        val error: String = ""
    )
}