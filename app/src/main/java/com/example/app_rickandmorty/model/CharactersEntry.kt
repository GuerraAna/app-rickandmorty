package com.example.app_rickandmorty.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Characters request entry.
 */
@Parcelize
data class CharactersEntry (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status : String,
    @SerializedName("species") val species: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin : LocationData,
    @SerializedName("location") val location : LocationData,
    @SerializedName("image") val image : String,
    @SerializedName("episode") val episode : List<String>
): Parcelable