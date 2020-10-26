package com.example.weather_app.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather_app.R
import com.example.weather_app.ui.adaptor.WeatherListAdapter
import com.example.weather_app.viewmodel.Status
import com.example.weather_app.viewmodel.WeatherForecastViewModel
import com.example.weather_app.viewmodel.WeatherForecastViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_forecast.*
import javax.inject.Inject

@AndroidEntryPoint
class ForecastFragment : Fragment() {

    @Inject
    lateinit var weatherForecastViewModelFactory: WeatherForecastViewModelFactory

    private lateinit var viewModel: WeatherForecastViewModel

    private val weatherListAdapter: WeatherListAdapter = WeatherListAdapter()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forecast, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupUI()

        val cityName = arguments?.let { ForecastFragmentArgs.fromBundle(it).cityName }

        viewModel = weatherForecastViewModelFactory.create(WeatherForecastViewModel::class.java)

        cityName?.let { nonNullCityName ->
            viewModel.getWeatherForecast(nonNullCityName).observe(viewLifecycleOwner,
                    {
                        it?.let { result ->
                            when (result.status) {
                                Status.LOADING -> {
                                    Log.d(TAG, "Loading...")
                                }
                                Status.SUCCESS -> {
                                    Log.d(TAG, "Success..." + result.data)
                                    result.data?.let { weatherData ->
                                        weatherListAdapter.setData(weatherData.list)
                                        forecastCityName.text = "${weatherData.city}, ${weatherData.country}"
                                        // use the data

                                    }
                                }
                                Status.ERROR -> {
                                    Log.e(TAG, "Error..." + result.message)
                                    // handle the error
                                }
                            }
                        }
                    })
        }
    }

    private fun setupUI() {
        weatherForecastList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL))
            adapter = weatherListAdapter
        }
    }

    companion object {
        private val TAG = ForecastFragment::class.java.simpleName
    }

}
