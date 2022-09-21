package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wind(
    @field:Json(name = "deg")
    val deg: Int? = 0,
    @field:Json(name = "gust")
    val gust: Double? = null,
    @field:Json(name = "speed")
    val speed: Double? = null
)