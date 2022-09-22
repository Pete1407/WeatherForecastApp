package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityModel(
    @field:Json(name = "name")
    val name: String? = null,
    @field:Json(name = "local_names")
    val local_names: LocalNames? =null,
    @field:Json(name = "lat")
    val lat: Double? = null,
    @field:Json(name = "lon")
    val lon: Double? = null,
    @field:Json(name = "country")
    val country: String? = null,
    @field:Json(name = "state")
    val state: String? = null,
    @field:Json(name = "coord")
    val coord: Coord? = null,
    @field:Json(name = "id")
    val id: Int? = 0,
    @field:Json(name = "population")
    val population: Int? = 0,
    @field:Json(name = "sunrise")
    val sunrise: Int? = 0,
    @field:Json(name = "sunset")
    val sunset: Int? = 0,
    @field:Json(name = "timezone")
    val timezone: Int? = 0
)