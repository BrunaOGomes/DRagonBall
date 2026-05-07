package br.com.example.dragonballapp.presentation.navigation

// MANTER SEU PACKAGE

object AppRoutes {

    const val LIST = "list"
    const val SEARCH = "search"
    const val DETAIL = "detail/{id}"

    fun detail(id: Int) = "detail/$id"
}