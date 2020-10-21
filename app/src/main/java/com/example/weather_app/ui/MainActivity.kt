package com.example.weather_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather_app.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkWeatherButton.setOnClickListener { getForecastForCity() }
    }

    private fun getForecastForCity() {
        val cityName = cityNameLabel.text.toString()
        startActivity(ForecastActivity.newInstance(this, cityName))
    }


}