package com.example.app_rickandmorty.api

import retrofit2.http.GET

interface CharacterApi {

    @GET("api/character")
    suspend fun getCharacters(): CharactersResponse
}