package com.example.app_rickandmorty

import com.example.app_rickandmorty.api.RetrofitInstance
import com.example.app_rickandmorty.model.CharactersEntry

internal class CharactersRepository {
    suspend fun getCharacters(): List<CharactersEntry> {
        return RetrofitInstance.api.getCharacters().characters
    }
}