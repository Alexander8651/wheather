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
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse
import com.amatai.weather.ui.viewmodels.VMFactory
import com.amatai.weather.ui.viewmodels.ViewmodelCityDetailsFragment
import java.text.SimpleDateFormat
import java.util.*

class CityDetailsFragment : Fragment() {

    val viewmodelCityDetailsFragment by viewModels<ViewmodelCityDetailsFragment> {
        VMFactory(RepositoryImpl(DataSources()))
    }

    lateinit var citySearchResponse: CitySearchResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            citySearchResponse = it.getParcelable("city")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCityBinding.inflate(inflater, container, false)
        context ?: binding.root

        val cityLocation = Location("")
        cityLocation.latitude = citySearchResponse.lat
        cityLocation.longitude = citySearchResponse.lon

        viewmodelCityDetailsFragment.getCityData(cityLocation.latitude, cityLocation.longitude)
            .observe(viewLifecycleOwner, Observer {
                Log.d("cityData", it.toString())

                binding.cityData = it
            })


        return binding.root
    }
}