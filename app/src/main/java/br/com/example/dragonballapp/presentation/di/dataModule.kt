package br.com.example.dragonballapp.presentation.di

import br.com.example.dragonballapp.data.remote.CharacterRemoteDataSource
import br.com.example.dragonballapp.domain.repository.CharacterRepository
import org.koin.dsl.module

import br.com.example.dragonballapp.data.repository.CharacterRepositoryImpl

val dataModule = module {


    // Repository
    single<CharacterRepository> {
        CharacterRepositoryImpl(remoteDataSource = get())
    }
}