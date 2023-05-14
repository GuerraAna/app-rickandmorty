package com.example.app_rickandmorty.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class LocationData(
    @SerializedName("name") val name: String,
    @SerializedName("url") var url: String
): Parcelable
