package com.example.weather_app.model.mapper

import com.example.weather_app.model.local.LocalWeatherForecast
import com.example.weather_app.model.network.FiveDayForecast

interface WeatherForecastResponseMapper {

    fun map(networkResponse: FiveDayForecast) : LocalWeatherForecast
}