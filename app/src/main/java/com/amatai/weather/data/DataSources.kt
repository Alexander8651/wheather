package com.amatai.weather.data

import com.amatai.weather.requestmanager.RetrofitService
import com.amatai.weather.requestmanager.apiresponses.CityDataResponse
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse
import com.amatai.weather.requestmanager.apiresponses.ForecastResponse
import com.amatai.weather.requestmanager.apiresponses.ListResponse

const val appid = "c6e381d8c7fF98f0fee43775817cf6ad"
const val metric = "metric"
class DataSources(){

    suspend fun getCities(city:String):List<CitySearchResponse>{
        return RetrofitService.retrofitService.getCities(city, 5, appid, metric).await()
    }

    suspend fun getCityData(lat:Double, lon:Double): CityDataResponse {
        return RetrofitService.retrofitService.getCityData(lat,lon,appid, metric).await()
    }

    suspend fun forecastData(lat:Double, lon:Double): ListResponse {
        return RetrofitService.retrofitService.forecastData(lat, lon, appid, 30, metric).await()
    }
}