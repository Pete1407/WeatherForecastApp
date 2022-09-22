package com.example.weatherforecastapp.feature.DetailForecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.domain.usecase.GetForecastUseCase
import com.example.weatherforecastapp.app.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailForecastViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase,
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private var city = MutableLiveData<Resource<List<CityModel>>>()
    val cityValue : LiveData<Resource<List<CityModel>>>
        get() = city

    private var weather = MutableLiveData<Resource<WeatherModel>>()
    val weatherValue : LiveData<Resource<WeatherModel>>
        get() = weather

    fun getPositionOfCity(cityName : String){
        city.postValue(Resource.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            val result = getForecastUseCase.execute(cityName)
            city.postValue(Resource.Success(result.data))
        }
    }

    fun getWeatherToday(lat: Double,lon : Double,unit : String?){
        weather.postValue(Resource.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            val result = getWeatherUseCase.execute(lat, lon,unit)
            weather.postValue(Resource.Success(result.data))
        }
    }
}