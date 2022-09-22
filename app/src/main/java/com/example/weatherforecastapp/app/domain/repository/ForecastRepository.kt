package com.example.weatherforecastapp.app.domain.repository

import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.model.WholeDayForecastModel
import com.example.weatherforecastapp.app.data.utils.Resource
import java.nio.DoubleBuffer

interface ForecastRepository {

    suspend fun getPositionOfCity(cityName : String):Resource<List<CityModel>>

    suspend fun getWeather(lat : Double,lon: Double, unit : String?):Resource<WeatherModel>

    suspend fun getWholeDayForecast(lat : Double, lon : Double):Resource<WholeDayForecastModel>
}