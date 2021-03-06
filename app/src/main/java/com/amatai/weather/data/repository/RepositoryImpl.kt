package com.amatai.weather.data.repository

import com.amatai.weather.data.DataSources
import com.amatai.weather.requestmanager.apiresponses.CityDataResponse
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse
import com.amatai.weather.requestmanager.apiresponses.ListResponse
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val dataSources: DataSources):Repository {


    override suspend fun getCitiesFromApi(city:String): List<CitySearchResponse> {
        return dataSources.getCities(city)
    }

    override suspend fun getCityData(lat:Double, lon:Double): CityDataResponse {
        return dataSources.getCityData(lat, lon)
    }

    override suspend fun forecastData(lat: Double, lon: Double): ListResponse {
        return dataSources.forecastData(lat, lon)
    }

}