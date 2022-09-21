package com.example.weatherforecastapp.app.di

import com.example.weatherforecastapp.app.domain.usecase.GetForecastUseCase
import com.example.weatherforecastapp.app.domain.usecase.GetWeatherUseCase
import com.example.weatherforecastapp.feature.DetailForecast.DetailForecastViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelFactoryModule {

    @Singleton
    @Provides
    fun provideDetailForecastViewModelFactory(
        getForecastUseCase: GetForecastUseCase,
        getWeatherUseCase: GetWeatherUseCase
    ):DetailForecastViewModelFactory{
        return DetailForecastViewModelFactory(getForecastUseCase,getWeatherUseCase)
    }
}