package com.example.weatherforecastapp.app.data.remote.datasourceImpl

import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.remote.datasource.WeatherRemoteDataSource
import com.example.weatherforecastapp.app.domain.ApiService
import retrofit2.Response

class WeatherRemoteDataSourceImpl(private val apiService: ApiService) : WeatherRemoteDataSource {

    override suspend fun getPositionOfCity(cityName : String): Response<List<CityModel>> {
        return apiService.getLocationOfCity(cityName)
    }

    override suspend fun getWeather(lat: Double, lon: Double): Response<WeatherModel> {
        return apiService.getWeatherToday(lat, lon)
    }
}