package com.amatai.weather.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.amatai.weather.data.repository.Repository
import kotlinx.coroutines.flow.collect

class ViewmodelCityDetailsFragment(private val repository: Repository) :ViewModel(){

    fun getCityData (lat:Double, lon:Double) = liveData {
        try {
            emit(repository.getCityData(lat, lon))
        }catch (e:Exception){

        }
    }

    fun forecastDate(lat:Double, lon:Double) = liveData {
        try {
            emit(repository.forecastData(lat, lon))
        }catch (e:java.lang.Exception){

        }
    }

}