package br.com.example.dragonballapp.domain.model

data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val race: String,
    val gender: String,
    val ki: String,
    val maxKi: String,
    val transformations: List<Transformation>
)