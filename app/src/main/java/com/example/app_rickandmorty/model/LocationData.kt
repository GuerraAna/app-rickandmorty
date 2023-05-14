package com.example.app_rickandmorty.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationData(
    @SerializedName("name") val name: String,
    @SerializedName("url") var url: String
): Parcelable
