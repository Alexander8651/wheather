package com.amatai.weather.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amatai.weather.data.repository.Repository

class ViewmodelCityDetailsFragment(private val repository: Repository) :ViewModel(){

    fun getCityData (lat:Double, lon:Double) = liveData {
        try {
            emit(repository.getCityData(lat, lon))
        }catch (e:Exception){

        }
    }

}