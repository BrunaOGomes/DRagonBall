package br.com.example.dragonballapp.data.model

import br.com.example.dragonballapp.domain.model.Character
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val image: String,
    val race: String,
    val gender: String,
    val ki: String,
    val maxKi: String,
    val transformations: List<TransformationResponse> = emptyList()
)

fun CharacterResponse.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        imageUrl = image,
        race = race,
        gender = gender,
        ki = ki,
        maxKi = maxKi,
        transformations = transformations.map {
            it.toDomain()
        }
    )
}