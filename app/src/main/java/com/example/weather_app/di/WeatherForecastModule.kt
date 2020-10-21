package com.example.weather_app.di

import com.example.weather_app.model.api.WeatherForecastAPI
import com.example.weather_app.model.mapper.OpenWeatherForecastRepsonseMapper
import com.example.weather_app.model.mapper.WeatherForecastResponseMapper
import com.example.weather_app.model.repository.OpenWeatherForecastRepository
import com.example.weather_app.model.repository.WeatherForecastRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object WeatherForecastModule {

    @Provides
    fun provideWeatherForecastResponseMapper() : WeatherForecastResponseMapper = OpenWeatherForecastRepsonseMapper()

    @Provides
    fun provideWeatherForecastRepository(weatherForecastAPI: WeatherForecastAPI, mapper: WeatherForecastResponseMapper)
            : WeatherForecastRepository = OpenWeatherForecastRepository(weatherForecastAPI, mapper)

    @Provides
    fun provideWeatherForecastAPI() : WeatherForecastAPI = getWeatherForecastAPI()
    private fun getWeatherForecastAPI(): WeatherForecastAPI {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()) //this can be another library like moshi, jackson
            .build()

        return retrofit
            .create(WeatherForecastAPI::class.java)
    }
}