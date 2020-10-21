package com.example.weather_app.model.local

data class LocalWeatherForecast(
    val city: String?,

    val country: String?,

    val list: List<LocalWeatherItem>?
)
