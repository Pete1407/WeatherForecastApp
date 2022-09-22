package com.example.weatherforecastapp.app.domain.repository

import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.utils.Resource

interface ForecastRepository {

    suspend fun getPositionOfCity(cityName : String):Resource<List<CityModel>>

    suspend fun getWeather(lat : Double,lon: Double, unit : String?):Resource<WeatherModel>

}