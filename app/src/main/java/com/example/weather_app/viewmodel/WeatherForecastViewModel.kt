package com.example.weather_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.weather_app.model.repository.WeatherForecastRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class WeatherForecastViewModel @Inject constructor(
    private val weatherRepository: WeatherForecastRepository
) : ViewModel() {

    fun getWeatherForecast(cityName: String) = liveData(context = Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = weatherRepository.getWeatherForecast(cityName)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Unknown error"))
        }
    }

}
