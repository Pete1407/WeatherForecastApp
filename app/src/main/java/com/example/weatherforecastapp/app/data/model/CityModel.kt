package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityModel(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "local_names")
    val local_names: LocalNames,
    @field:Json(name = "lat")
    val lat: Double,
    @field:Json(name = "lon")
    val lon: Double,
    @field:Json(name = "country")
    val country: String,
    @field:Json(name = "state")
    val state: String
)