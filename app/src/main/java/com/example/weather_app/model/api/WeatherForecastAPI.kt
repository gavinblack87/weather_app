package com.example.weather_app.model.api

import com.example.weather_app.model.network.FiveDayForecast

interface WeatherForecastAPI {
    fun getWeatherForecast(cityName: String) : FiveDayForecast
}