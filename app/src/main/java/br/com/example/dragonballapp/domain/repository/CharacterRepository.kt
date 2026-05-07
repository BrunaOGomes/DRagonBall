package br.com.example.dragonballapp.domain.repository

import br.com.example.dragonballapp.domain.common.Resource
import br.com.example.dragonballapp.domain.model.Character
import br.com.example.dragonballapp.domain.model.CharacterListItem

// Manter o package do seu app
// Fazer os imports


interface CharacterRepository {

    suspend fun getCharacters():
            Resource<List<CharacterListItem>>

    suspend fun getCharacterById(
        id: Int
    ): Resource<Character>
}