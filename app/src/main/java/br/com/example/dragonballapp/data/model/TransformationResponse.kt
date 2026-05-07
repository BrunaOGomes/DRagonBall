package br.com.example.dragonballapp.data.model

import br.com.example.dragonballapp.domain.model.Transformation
import kotlinx.serialization.Serializable

@Serializable
data class TransformationResponse(
    val id: Int,
    val name: String,
    val image: String,
    val ki: String
)
fun TransformationResponse.toDomain(): Transformation {
    return Transformation(
        id = id,
        name = name,
        imageUrl = image,
        ki = ki
    )
}