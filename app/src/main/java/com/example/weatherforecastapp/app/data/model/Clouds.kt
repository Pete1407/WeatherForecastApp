package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Clouds(
    @field:Json(name = "all")
    val all: Int? = 0
)