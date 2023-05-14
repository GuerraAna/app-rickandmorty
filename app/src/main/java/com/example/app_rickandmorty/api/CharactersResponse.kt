package com.example.app_rickandmorty.api

import android.os.Parcelable
import com.example.app_rickandmorty.model.CharactersEntry
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
class CharactersResponse(
    @SerializedName("results")
    val characters: List<CharactersEntry>
) : Parcelable