package br.com.example.dragonballapp.presentation.dragonball.search

// Manter o package

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CharacterSearchViewModel : ViewModel() {

    private val _characterId =
        MutableStateFlow("")

    val characterId: StateFlow<String> =
        _characterId

    fun onIdChanged(value: String) {
        _characterId.value = value.filter { it.isDigit() }
    }

    fun getId(): Int? {
        return _characterId.value.toIntOrNull()
    }
}