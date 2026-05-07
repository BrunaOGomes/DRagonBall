package br.com.example.dragonballapp.domain.usecase

import br.com.example.dragonballapp.domain.common.Resource
import br.com.example.dragonballapp.domain.model.Character
import br.com.example.dragonballapp.domain.model.Transformation
import br.com.example.dragonballapp.domain.repository.CharacterRepository

// Manter o package do seu app
// Fazer os imports

class GetCharacterByIdUseCase(
    private val repository: CharacterRepository
) {

    suspend operator fun invoke(id: Int): Resource<Character> {

        return repository.getCharacterById(id)
    }
}