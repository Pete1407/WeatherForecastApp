package com.example.weatherforecastapp.app.di

import com.example.weatherforecastapp.app.domain.repository.ForecastRepository
import com.example.weatherforecastapp.app.domain.usecase.GetForecastUseCase
import com.example.weatherforecastapp.app.domain.usecase.GetWeatherUseCase
import com.example.weatherforecastapp.app.domain.usecase.GetWholeDayForecastUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetForecastUseCase(repository: ForecastRepository):GetForecastUseCase{
        return GetForecastUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetWeatherUseCase(repository: ForecastRepository):GetWeatherUseCase{
        return GetWeatherUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetWholeDayForecastUseCase(repository: ForecastRepository):GetWholeDayForecastUseCase{
        return GetWholeDayForecastUseCase(repository)
    }
}