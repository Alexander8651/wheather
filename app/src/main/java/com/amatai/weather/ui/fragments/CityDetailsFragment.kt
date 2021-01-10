package com.amatai.weather.ui.fragments

import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.amatai.weather.data.DataSources
import com.amatai.weather.data.repository.RepositoryImpl
import com.amatai.weather.databinding.FragmentCityBinding
import com.amatai.weather.requestmanager.apiresponses.CityDataResponse
import com.amatai.weather.ui.adapters.CityAdapterHome
import com.amatai.weather.ui.adapters.CityForecast
import com.amatai.weather.ui.viewmodels.VMFactory
import com.amatai.weather.ui.viewmodels.ViewmodelCityDetailsFragment

class CityDetailsFragment : Fragment() {

    val viewmodelCityDetailsFragment by viewModels<ViewmodelCityDetailsFragment> {
        VMFactory(RepositoryImpl(DataSources()))
    }
    lateinit var binding:FragmentCityBinding

    lateinit var cityDataResponse: CityDataResponse
    lateinit var cityLocation:Location

    lateinit var cityAdapterHome: CityForecast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cityDataResponse = it.getParcelable("city")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityBinding.inflate(inflater, container, false)
        context ?: binding.root

        cityLocation = Location("")
        cityLocation.latitude = cityDataResponse.coord?.lat!!
        cityLocation.longitude = cityDataResponse.coord?.lon!!

        viewmodelCityDetailsFragment.getCityData(cityLocation.latitude, cityLocation.longitude)
            .observe(viewLifecycleOwner, Observer {
                //Log.d("cityData", it.toString())

                binding.cityData = it
                binding.weather = it.weather!![0]
            })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewmodelCityDetailsFragment.forecastDate(cityLocation.latitude, cityLocation.longitude)
            .observe(viewLifecycleOwner, Observer {
                Log.d("forecastData", it.toString())
                cityAdapterHome = CityForecast()


                binding.rvForecast.apply {
                    adapter = cityAdapterHome
                }
                cityAdapterHome.submitList(it.list)
            })

    }
}