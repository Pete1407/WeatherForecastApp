package com.example.weatherforecastapp.app.di

import com.example.weatherforecastapp.app.data.remote.datasource.WeatherRemoteDataSource
import com.example.weatherforecastapp.app.data.remote.datasourceImpl.WeatherRemoteDataSourceImpl
import com.example.weatherforecastapp.app.data.remote.repositoryImpl.WeatherRepositoryImpl
import com.example.weatherforecastapp.app.domain.repository.ForecastRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideForecastRepository(weatherRemoteDataSource: WeatherRemoteDataSource):ForecastRepository{
        return WeatherRepositoryImpl(weatherRemoteDataSource)
    }


}