package com.example.weatherforecastapp.app.data.remote.datasourceImpl

import com.example.weatherforecastapp.app.data.model.DataModel
import com.example.weatherforecastapp.app.data.remote.datasource.WeatherRemoteDataSource
import retrofit2.Response

class WeatherRemoteDataSourceImpl : WeatherRemoteDataSource {

    override suspend fun getWeatherForecast(): Response<DataModel> {
        TODO("Not yet implemented")
    }
}