package com.example.weatherforecastapp.app.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Coord(
    @field:Json(name = "lat")
    val lat: Double? = null,
    @field:Json(name = "lon")
    val lon: Double? = null
):Parcelable