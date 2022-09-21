package com.example.weatherforecastapp.app.domain.repository

import com.example.weatherforecastapp.app.data.model.DataModel
import com.example.weatherforecastapp.app.data.utils.Resource

interface ForecastRepository {

    suspend fun getWeatherToday():Resource<DataModel>

}