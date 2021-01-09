package com.amatai.weather.data.repository

import com.amatai.weather.data.DataSources
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse

class RepositoryImpl(private val dataSources: DataSources):Repository {


    override suspend fun getCitiesFromApi(city:String): List<CitySearchResponse> {
        return dataSources.getCities(city)
    }
}