package com.example.weatherforecastapp.app.domain.usecase

import com.example.weatherforecastapp.app.data.model.WholeDayForecastModel
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.domain.repository.ForecastRepository
import javax.inject.Inject

class GetWholeDayForecastUseCase @Inject constructor(private val repository: ForecastRepository) {

    suspend fun execute(lat : Double,lon : Double,unit : String?):Resource<WholeDayForecastModel>{
        return repository.getWholeDayForecast(lat,lon,unit)
    }
}