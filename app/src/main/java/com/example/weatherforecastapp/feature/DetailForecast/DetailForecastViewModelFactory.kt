package com.example.weatherforecastapp.feature.DetailForecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherforecastapp.app.domain.usecase.GetForecastUseCase
import com.example.weatherforecastapp.app.domain.usecase.GetWeatherUseCase
import javax.inject.Inject

class DetailForecastViewModelFactory @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase,
    private val getWeatherUseCase: GetWeatherUseCase
    ) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailForecastViewModel::class.java)){
            return DetailForecastViewModel(
                getForecastUseCase,
                getWeatherUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}