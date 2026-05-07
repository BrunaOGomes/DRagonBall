package br.com.example.dragonballapp.presentation.di




import org.koin.dsl.module

val domainModule = module {

    factory {
        GetCharacterUseCase(repository = get())
    }

    factory {
        GetCharacterByNumberUseCase(repository = get())
    }
}