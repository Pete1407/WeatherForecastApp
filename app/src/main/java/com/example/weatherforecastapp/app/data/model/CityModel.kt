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
    val state: String? = null
)