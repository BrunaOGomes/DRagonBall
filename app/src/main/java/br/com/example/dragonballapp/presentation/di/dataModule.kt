package br.com.example.dragonballapp.presentation.di

import br.com.example.dragonballapp.data.remote.CharacterRemoteDataSource
import br.com.example.dragonballapp.domain.repository.CharacterRepository
import org.koin.dsl.module

val dataModule = module {

    single<CharacterRemoteDataSource> {
        PokemonRemoteDataSourceImpl(api = get())
    }

    single<CharacterRepository> {
        PokemonRepositoryImpl(
            remoteDataSource = get()
        )
    }
}