package com.example.weatherforecastapp.app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@JsonClass(generateAdapter = true)
data class WeatherModel(
    @field:Json(name = "coord")
    val coord: Coord? = null,
    @field:Json(name = "weather")
    val weather: List<Weather> = arrayListOf(),
    @field:Json(name = "base")
    val base: String? = null,
    @field:Json(name = "main")
    val main: Main? = null,
    @field:Json(name = "visibility")
    val visibility: Int? = 0,
    @field:Json(name = "wind")
    val wind: Wind? = null,
    @field:Json(name = "rain")
    val rain: Rain? = null,
    @field:Json(name = "clouds")
    val clouds: Clouds? = null,
    @field:Json(name = "dt")
    val dt: Long? = 0,
    @field:Json(name = "sys")
    val sys: Sys? = null,
    @field:Json(name = "timezone")
    val timezone: Int? = 0,
    @field:Json(name = "id")
    val id: Int? = 0,
    @field:Json(name = "name")
    val name: String? = null,
    @field:Json(name = "cod")
    val cod: Int? = 0,
)