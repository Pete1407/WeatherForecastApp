package com.example.weatherforecastapp.app.di

import com.example.weatherforecastapp.app.data.remote.datasource.WeatherRemoteDataSource
import com.example.weatherforecastapp.app.data.remote.datasourceImpl.WeatherRemoteDataSourceImpl
import com.example.weatherforecastapp.app.domain.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideWeatherRemoteDataSource(api : ApiService):WeatherRemoteDataSource{
        return WeatherRemoteDataSourceImpl(api)
    }


}