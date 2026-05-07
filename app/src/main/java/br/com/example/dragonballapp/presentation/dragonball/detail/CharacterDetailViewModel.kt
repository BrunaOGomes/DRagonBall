package br.com.example.dragonballapp.presentation.dragonball.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.example.dragonballapp.domain.common.Resource
import br.com.example.dragonballapp.domain.model.Character
import br.com.example.dragonballapp.domain.usecase.GetCharacterByIdUseCase
import br.com.example.dragonballapp.presentation.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<UiState<Character>>(UiState.Initial)

    val uiState: StateFlow<UiState<Character>> =
        _uiState

    fun getCharacterById(id: Int) {

        viewModelScope.launch {

            _uiState.value = UiState.Loading

            when (val result = getCharacterByIdUseCase(id)) {

                is Resource.Success -> {
                    _uiState.value =
                        UiState.Success(result.data)
                }

                is Resource.Error -> {
                    _uiState.value =
                        UiState.Error(result.message)
                }

                Resource.Loading -> {
                    _uiState.value = UiState.Loading
                }
            }
        }
    }
}
