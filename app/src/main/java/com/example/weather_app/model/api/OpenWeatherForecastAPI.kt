package com.example.weather_app.model.api

import com.example.weather_app.model.network.FiveDayForecast

class OpenWeatherForecastAPI : WeatherForecastAPI {
    override fun getWeatherForecast(cityName: String): FiveDayForecast {
        TODO("Not yet implemented")
    }
}