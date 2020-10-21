package com.example.weather_app.model.repository

import com.example.weather_app.model.local.LocalWeatherForecast

class OpenWeatherForecastRepository : WeatherForecastRepository {
    override fun getWeatherForecast(cityName: String) : LocalWeatherForecast {
        //1.Get API data
        //2.Pass API response through mapper
        //3. Return the result of the mapper

        TODO("Not yet implemented")
    }
}