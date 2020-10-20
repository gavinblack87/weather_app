package com.example.weather_app.model.network

import com.google.gson.annotations.SerializedName

data class City (
    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("coord")
    val coord: Coord? = null,

    @field:SerializedName("sunrise")
    val sunrise: Int? = 0,

    @field:SerializedName("timezone")
    val timezone: Int? = 0,

    @field:SerializedName("sunset")
    val sunset: Int? = 0,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = 0,

    @field:SerializedName("population")
    val population: Int? = 0,
)