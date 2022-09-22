package com.example.weatherforecastapp.app.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Rain(
    @field:Json(name = "1h")
    val `1h`: Double? = null,
    @field:Json(name = "3h")
    val `3h`: Double? = null
):Parcelable