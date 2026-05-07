package br.com.example.dragonballapp.domain.model

import android.view.animation.Transformation

//Manter o package do seu app

data class Transformation(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val ki: String
)