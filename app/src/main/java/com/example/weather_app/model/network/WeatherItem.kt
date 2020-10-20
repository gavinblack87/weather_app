package com.example.weather_app.model.network

import com.google.gson.annotations.SerializedName

data class WeatherItem (
    @field:SerializedName("icon")
    val icon: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("main")
    val main: String? = null,

    @field:SerializedName("id")
    val id: Int? = 0
)