package com.example.weatherforecastapp.app.domain.usecase

import com.example.weatherforecastapp.app.data.model.DataModel
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.domain.repository.ForecastRepository

class GetForecastUseCase(private val repository: ForecastRepository) {

    suspend fun getWeatherToday():Resource<DataModel>{
        return repository.getWeatherToday()
    }
}