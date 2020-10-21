package com.example.weather_app.model.mapper

import com.example.weather_app.model.local.LocalWeatherForecast
import com.example.weather_app.model.local.LocalWeatherItem
import com.example.weather_app.model.network.FiveDayForecast
import com.example.weather_app.model.network.ListItem

class OpenWeatherForecastRepsonseMapper : WeatherForecastResponseMapper{

    override fun map(networkResponse: FiveDayForecast): LocalWeatherForecast =
        LocalWeatherForecast(
            networkResponse.city?.name,
            networkResponse.city?.country,
            getLocalWeatherListItems(networkResponse.list)
        )


    private fun getLocalWeatherListItems(listItems: List<ListItem>?): List<LocalWeatherItem>? {
        val localWeatherItemList = arrayListOf<LocalWeatherItem>()

        listItems?.forEach { listItem ->
            val localItem = LocalWeatherItem(
                listItem.main?.temp,
                listItem.main?.tempMin,
                listItem.main?.humidity,
                listItem.main?.pressure,
                listItem.main?.feelsLike,
                listItem.main?.tempMax,
                listItem.wind?.speed,
                listItem.weather?.get(0)?.main,
                listItem.weather?.get(0)?.description,
                listItem.dtTxt?.substring(0,10),
                listItem.dtTxt?.substring(11, 19)
            )
            localWeatherItemList.add(localItem)
        }

        return localWeatherItemList
    }
}
