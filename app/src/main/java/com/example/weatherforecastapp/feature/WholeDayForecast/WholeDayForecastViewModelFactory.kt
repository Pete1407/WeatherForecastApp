package com.example.weatherforecastapp.feature.WholeDayForecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherforecastapp.app.domain.usecase.GetWholeDayForecastUseCase

class WholeDayForecastViewModelFactory(
    private val getWholeDayForecastUseCase: GetWholeDayForecastUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WholeDayForecastViewModel::class.java)){
            return WholeDayForecastViewModel(
                getWholeDayForecastUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}