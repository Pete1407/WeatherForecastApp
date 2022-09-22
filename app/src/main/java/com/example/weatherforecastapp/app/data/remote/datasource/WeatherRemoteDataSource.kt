package com.example.weatherforecastapp.app.data.remote.datasource

import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.model.WholeDayForecastModel
import retrofit2.Response

interface WeatherRemoteDataSource {

    suspend fun getPositionOfCity(cityName : String):Response<List<CityModel>>

    suspend fun getWeather(lat : Double, lon : Double, unit : String?):Response<WeatherModel>

    suspend fun getWholeDayForecast(lat : Double, lon : Double):Response<WholeDayForecastModel>
}