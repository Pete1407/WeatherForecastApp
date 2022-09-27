package com.example.weatherforecastapp.app.domain.usecase

import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.domain.repository.ForecastRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val repository: ForecastRepository) {

    suspend fun execute(lat : Double,lon : Double,unit : String?):Resource<WeatherModel>{
        return repository.getWeather(lat,lon,unit)
    }
}