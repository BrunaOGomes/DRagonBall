package br.com.example.dragonballapp.data.remote

import br.com.example.dragonballapp.data.model.CharacterListResponse
import br.com.example.dragonballapp.data.model.CharacterResponse
import br.com.example.dragonballapp.domain.common.Resource

// Manter o package
class CharacterRemoteDataSourceImpl(
    private val api: DragonBallApi
) : CharacterRemoteDataSource {

    override suspend fun getCharacters():
            CharacterListResponse {

        return api.getCharacters()
    }

    override suspend fun getCharacterById(
        id: Int
    ): CharacterResponse {

        return api.getCharacterById(id)
    }
}