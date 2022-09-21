package com.example.weatherforecastapp.feature.DetailForecast

import androidx.lifecycle.ViewModel
import com.example.weatherforecastapp.app.domain.usecase.GetForecastUseCase

class DetailForecastViewModel(
    private val getForecastUseCase: GetForecastUseCase
) : ViewModel() {
}