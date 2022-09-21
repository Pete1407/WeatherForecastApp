package com.example.weatherforecastapp.app.data.remote.datasource

import com.example.weatherforecastapp.app.data.model.DataModel
import retrofit2.Response

interface WeatherRemoteDataSource {

    suspend fun getWeatherForecast():Response<DataModel>
}