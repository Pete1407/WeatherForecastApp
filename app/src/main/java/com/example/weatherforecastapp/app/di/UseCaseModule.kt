package com.example.weatherforecastapp.app.di

import com.example.weatherforecastapp.app.domain.repository.ForecastRepository
import com.example.weatherforecastapp.app.domain.usecase.GetForecastUseCase
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
}