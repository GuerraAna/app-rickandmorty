package com.example.app_rickandmorty

import com.example.app_rickandmorty.model.CharactersEntry

internal sealed class CharactersViewState {
    object Loading: CharactersViewState()
    object Error: CharactersViewState()
    data class Loaded(val characters: List<CharactersEntry>): CharactersViewState()
}