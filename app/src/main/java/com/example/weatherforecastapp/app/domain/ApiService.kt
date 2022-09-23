package com.example.weatherforecastapp.app.domain

import com.example.weatherforecastapp.BuildConfig
import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.model.WholeDayForecastModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("geo/1.0/direct")
    suspend fun getLocationOfCity(
        @Query("q")q : String,
        @Query("appid") appid : String = BuildConfig.API_KEY
    ):Response<List<CityModel>>

    @GET("data/2.5/weather")
    suspend fun getWeatherToday(
        @Query("lat")lat : Double,
        @Query("lon")lon : Double,
        @Query("units") units : String?,
        @Query("appid") appid: String = BuildConfig.API_KEY
    ):Response<WeatherModel>

    @GET("data/2.5/forecast")
    suspend fun getWholeDayForecast(
        @Query("lat")lat : Double,
        @Query("lon")lon : Double,
        @Query("units") units: String?,
        @Query("appid") appid : String = BuildConfig.API_KEY
    ):Response<WholeDayForecastModel>
}