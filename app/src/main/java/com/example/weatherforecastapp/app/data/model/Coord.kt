package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coord(
    @field:Json(name = "lat")
    val lat: Double? = null,
    @field:Json(name = "lon")
    val lon: Double? = null
)