package com.example.weatherforecastapp.app.data.remote.repositoryImpl

import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.model.ErrorResponse
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.model.WholeDayForecastModel
import com.example.weatherforecastapp.app.data.remote.datasource.WeatherRemoteDataSource
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.domain.repository.ForecastRepository
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody
import retrofit2.Response

class WeatherRepositoryImpl(private val remoteDataSource: WeatherRemoteDataSource) : ForecastRepository {

    override suspend fun getPositionOfCity(cityName : String): Resource<List<CityModel>> {
        return safeApiCall {
            remoteDataSource.getPositionOfCity(cityName)
        }
    }

    override suspend fun getWeather(lat: Double, lon: Double, unit : String?): Resource<WeatherModel> {
        return safeApiCall {
            remoteDataSource.getWeather(lat,lon, unit)
        }
    }

    override suspend fun getWholeDayForecast(lat: Double, lon: Double): Resource<WholeDayForecastModel> {
        return safeApiCall {
            remoteDataSource.getWholeDayForecast(lat,lon)
        }
    }

    // we'll use this function in all
    // repos to handle api errors.
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {

        // Returning api response
        // wrapped in Resource class

        // Here we are calling api lambda
        // function that will return response
        // wrapped in Retrofit's Response class
        val response: Response<T> = apiToBeCalled()
        if (response.isSuccessful) {
            // In case of success response we
            // are returning Resource.Success object
            // by passing our data in it.
            //Resource.Success(result = response.body())
            return Resource.Success(response.body()!!)
        } else {
            // parsing api's own custom json error
            // response in ExampleErrorResponse pojo
            val errorResponse: ErrorResponse? = convertErrorBody(response.errorBody())
            // Simply returning api's own failure message
            //Resource.Error(msg = errorResponse?.failureMessage ?: "Something went wrong")
            throw Exception(errorResponse.toString())
        }
    }

    // If you don't wanna handle api's own
    // custom error response then ignore this function
    private fun convertErrorBody(errorBody: ResponseBody?): ErrorResponse? {
        return try {
            errorBody?.source()?.let {
                val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (exception: Exception) {
            null
        }
    }
}