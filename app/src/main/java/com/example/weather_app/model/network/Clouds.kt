package com.example.weather_app.model.network

import com.google.gson.annotations.SerializedName

data class Clouds (
    @field:SerializedName("all")
    val all: Int? = 0

)