package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weather(
    @field:Json(name = "description")
    val description: String? = null,
    @field:Json(name = "icon")
    val icon: String? = null,
    @field:Json(name = "id")
    val id: Int? = 0,
    @field:Json(name = "main")
    val main: String? = null
)