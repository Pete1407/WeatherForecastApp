package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WholeDayForecastModel(
    @field:Json(name = "city")
    val city: CityModel? = null,
    @field:Json(name = "cnt")
    val cnt: Int? = 0,
    @field:Json(name = "cod")
    val cod: String? = null,
    @field:Json(name = "list")
    val list: List<DetailModel> = arrayListOf(),
    @field:Json(name = "message")
    val message: Int? = 0
)