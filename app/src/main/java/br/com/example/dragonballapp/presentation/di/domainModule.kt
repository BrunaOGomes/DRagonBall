package br.com.example.dragonballapp.presentation.di

import br.com.example.dragonballapp.domain.usecase.GetCharacterByNumberUseCase
import br.com.example.dragonballapp.domain.usecase.GetCharacterUseCase


import org.koin.dsl.module

val domainModule = module {

    factory {
        GetCharacterUseCase(repository = get())
    }

    factory {
        GetCharacterByNumberUseCase(repository = get())
    }
}