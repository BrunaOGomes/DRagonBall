package br.com.example.dragonballapp.data.repository

import br.com.example.dragonballapp.data.model.toDomain
import br.com.example.dragonballapp.data.remote.CharacterRemoteDataSource
import br.com.example.dragonballapp.domain.common.Resource
import br.com.example.dragonballapp.domain.model.Character
import br.com.example.dragonballapp.domain.model.CharacterListItem
import br.com.example.dragonballapp.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val remoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {

    override suspend fun getCharacters():
            Resource<List<CharacterListItem>> {

        return try {

            val response =
                remoteDataSource.getCharacters()

            Resource.Success(
                response.items.map {
                    it.toDomain()
                }
            )

        } catch (e: Exception) {

            Resource.Error(
                "Erro ao carregar personagens"
            )
        }
    }

    override suspend fun getCharacterById(id: Int): Resource<Character> {
        return try {

            val response =
                remoteDataSource.getCharacterById(id)

            Resource.Success(
                response.toDomain()
            )

        } catch (e: Exception) {

            Resource.Error(
                "Erro ao carregar personagem"
            )
        }
    }
}