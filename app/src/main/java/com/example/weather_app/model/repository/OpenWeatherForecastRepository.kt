package com.example.weather_app.model.repository

import com.example.weather_app.model.api.WeatherForecastAPI
import com.example.weather_app.model.local.LocalWeatherForecast
import com.example.weather_app.model.mapper.WeatherForecastResponseMapper

class OpenWeatherForecastRepository(
    private val weatherForecastAPI: WeatherForecastAPI,
    private val mapper: WeatherForecastResponseMapper
) : WeatherForecastRepository {
    override suspend fun getWeatherForecast(cityName: String): LocalWeatherForecast {
        val networkResponse = weatherForecastAPI.getWeatherForecast(cityName, "812d9d979e17eba68b4c4fc683a86568", "metric")
        return mapper.map(networkResponse)
    }
}