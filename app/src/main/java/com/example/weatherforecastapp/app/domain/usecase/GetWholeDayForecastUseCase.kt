package com.example.weatherforecastapp.app.domain.usecase

import com.example.weatherforecastapp.app.data.model.WholeDayForecastModel
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.domain.repository.ForecastRepository

class GetWholeDayForecastUseCase(private val repository: ForecastRepository) {

    suspend fun execute(lat : Double,lon : Double):Resource<WholeDayForecastModel>{
        return repository.getWholeDayForecast(lat,lon)
    }
}