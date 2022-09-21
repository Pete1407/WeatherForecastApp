package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sys(
    @field:Json(name = "country")
    val country: String? = null,
    @field:Json(name = "id")
    val id: Int? = 0,
    @field:Json(name = "sunrise")
    val sunrise: Int? = 0,
    @field:Json(name = "sunset")
    val sunset: Int? = 0,
    @field:Json(name = "type")
    val type: Int? = 0
)