package com.example.weather_app.model.repository

import com.example.weather_app.model.local.LocalWeatherForecast

interface WeatherForecastRepository {

    suspend fun getWeatherForecast(cityName: String) : LocalWeatherForecast
}