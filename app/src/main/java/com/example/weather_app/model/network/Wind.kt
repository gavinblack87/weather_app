package com.example.weather_app.model.network

import com.google.gson.annotations.SerializedName

data class Wind (
    @field:SerializedName("deg")
    val deg: Int = 0,

    @field:SerializedName("speed")
    val speed: Double = 0.0

)