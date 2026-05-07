package br.com.example.dragonballapp.data.remote

import br.com.example.dragonballapp.data.model.CharacterListResponse
import br.com.example.dragonballapp.data.model.CharacterResponse
import br.com.example.dragonballapp.domain.common.Resource

// Manter o package

interface CharacterRemoteDataSource {

    suspend fun getCharacters():
            CharacterListResponse

    suspend fun getCharacterById(
        id: Int
    ): CharacterResponse
}