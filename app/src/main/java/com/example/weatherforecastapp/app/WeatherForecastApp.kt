package com.example.weatherforecastapp.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeatherForecastApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}