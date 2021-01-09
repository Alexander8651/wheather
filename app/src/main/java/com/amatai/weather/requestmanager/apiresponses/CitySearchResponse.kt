package com.amatai.weather.requestmanager.apiresponses

data class CitySearchResponse (
    val name:String,
    val lat:Double,
    val lon:Double,
    val country:String
)