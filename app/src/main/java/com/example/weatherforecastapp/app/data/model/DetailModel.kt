package com.example.weatherforecastapp.app.data.model

import com.example.weatherforecastapp.app.data.model.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailModel(
    @field:Json(name = "clouds")
    val clouds: Clouds? = null,
    @field:Json(name = "dt")
    val dt: Long? = null,
    @field:Json(name = "dt_txt")
    val dt_txt: String? = null,
    @field:Json(name = "main")
    val main: Main? = null,
    @field:Json(name = "pop")
    val pop: Double? = null,
    @field:Json(name = "rain")
    val rain: Rain? = null,
    @field:Json(name = "sys")
    val sys: Sys? = null,
    @field:Json(name = "visibility")
    val visibility: Int? = 0,
    @field:Json(name = "weather")
    val weather: List<Weather> = arrayListOf(),
    @field:Json(name = "wind")
    val wind: Wind? = null,
    @field:Json(name = "units")
    var units : String? = null
)