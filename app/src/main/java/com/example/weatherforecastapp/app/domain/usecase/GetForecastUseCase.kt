package com.example.weatherforecastapp.app.domain.usecase

import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.domain.repository.ForecastRepository

class GetForecastUseCase(private val repository: ForecastRepository) {

    suspend fun execute(cityName : String):Resource<List<CityModel>>{
        return repository.getPositionOfCity(cityName)
    }
}