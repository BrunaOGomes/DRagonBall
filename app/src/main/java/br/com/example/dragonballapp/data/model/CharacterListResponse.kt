package br.com.example.dragonballapp.data.model

import br.com.example.dragonballapp.domain.model.CharacterListItem
import kotlinx.serialization.Serializable

@Serializable
data class CharacterListResponse(
    val items: List<CharacterListItemResponse>
)

@Serializable
data class CharacterListItemResponse(
    val id: Int,
    val name: String,
    val image: String
)
fun CharacterListItemResponse.toDomain(): CharacterListItem {
    return CharacterListItem(
        id = id,
        name = name,
        imageUrl = image
    )
}