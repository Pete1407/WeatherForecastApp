package com.example.weatherforecastapp.app.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Clouds(
    @field:Json(name = "all")
    val all: Int? = 0
):Parcelable