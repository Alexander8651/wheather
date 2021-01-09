package com.amatai.weather.data

import com.amatai.weather.requestmanager.RetrofitService
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse

class DataSources(){

    suspend fun getCities(city:String):List<CitySearchResponse>{
        return RetrofitService.retrofitService.getCities(city, 5, "c6e381d8c7fF98f0fee43775817cf6ad","metric").await()
    }
}