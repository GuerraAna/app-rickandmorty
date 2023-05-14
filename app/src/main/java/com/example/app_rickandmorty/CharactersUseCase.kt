package com.example.app_rickandmorty

import com.example.app_rickandmorty.model.CharactersEntry

internal class CharactersUseCase(
    private val repository: CharactersRepository = CharactersRepository()
) {
    suspend fun getCharacters(): List<CharactersEntry> = repository.getCharacters()
}