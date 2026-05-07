package br.com.example.dragonballapp.data.remote

// Manter o package do seu app

import br.com.example.dragonballapp.data.model.CharacterListResponse
import br.com.example.dragonballapp.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DragonBallApi {

    @GET("characters")
    suspend fun getCharacters(): CharacterListResponse

    @GET("characters/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ): CharacterResponse
}