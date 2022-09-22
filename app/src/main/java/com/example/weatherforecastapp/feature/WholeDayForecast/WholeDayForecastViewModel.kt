package com.example.weatherforecastapp.feature.WholeDayForecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecastapp.app.data.model.WholeDayForecastModel
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.domain.usecase.GetWholeDayForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WholeDayForecastViewModel @Inject constructor(
    private val getWholeDayForecastUseCase: GetWholeDayForecastUseCase
) : ViewModel() {

    private var wholeDayForecast = MutableLiveData<Resource<WholeDayForecastModel>>()
    val wholeDayForecastData : LiveData<Resource<WholeDayForecastModel>>
        get() = wholeDayForecast

    fun getWholeDayForecast(lat : Double,lon : Double){
        wholeDayForecast.postValue(Resource.Loading())
        viewModelScope.launch {
            val result = getWholeDayForecastUseCase.execute(lat,lon)
            wholeDayForecast.postValue(result)
        }
    }


}