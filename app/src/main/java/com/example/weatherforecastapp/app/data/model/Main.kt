package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Main(
    @field:Json(name="feels_like")
    val feels_like: Double? = null,
    @field:Json(name="grnd_level")
    val grnd_level: Int? = 0,
    @field:Json(name="humidity")
    val humidity: Int? = 0,
    @field:Json(name="pressure")
    val pressure: Int? = 0,
    @field:Json(name="sea_level")
    val sea_level: Int? = 0,
    @field:Json(name="temp")
    val temp: Double? = null,
    @field:Json(name="temp_max")
    val temp_max: Double? = null,
    @field:Json(name="temp_min")
    val temp_min: Double? = null
)