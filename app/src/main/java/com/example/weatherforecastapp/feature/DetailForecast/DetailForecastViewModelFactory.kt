package com.example.weatherforecastapp.feature.DetailForecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherforecastapp.app.domain.usecase.GetForecastUseCase

class DetailForecastViewModelFactory(private val getForecastUseCase: GetForecastUseCase) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailForecastViewModel::class.java)){
            return DetailForecastViewModel(
                getForecastUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}