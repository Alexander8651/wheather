package com.amatai.weather.data.repository

import com.amatai.weather.requestmanager.apiresponses.CityDataResponse
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse
import com.amatai.weather.requestmanager.apiresponses.ForecastResponse
import com.amatai.weather.requestmanager.apiresponses.ListResponse

interface Repository {
    suspend fun getCitiesFromApi(city:String):List<CitySearchResponse>

    suspend fun getCityData(lat:Double, lon:Double): CityDataResponse

    suspend fun forecastData(lat:Double, lon:Double): ListResponse
}