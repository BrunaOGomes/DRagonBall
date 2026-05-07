package br.com.example.dragonballapp.domain.usecase

import br.com.example.dragonballapp.domain.common.Resource
import br.com.example.dragonballapp.domain.model.CharacterListItem
import br.com.example.dragonballapp.domain.repository.CharacterRepository

class GetCharactersUseCase(
    private val repository: CharacterRepository
) {

    suspend operator fun invoke():
            Resource<List<CharacterListItem>> {

        return repository.getCharacters()
    }
}