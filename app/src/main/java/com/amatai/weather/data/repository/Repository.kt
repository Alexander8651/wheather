package com.amatai.weather.data.repository

import com.amatai.weather.requestmanager.apiresponses.CityDataResponse
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse

interface Repository {
    suspend fun getCitiesFromApi(city:String):List<CitySearchResponse>

    suspend fun getCityData(lat:Double, lon:Double): CityDataResponse
}