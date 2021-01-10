package com.amatai.weather.requestmanager.apiresponses

data class CityResponse(
    val id: Long? = null,
    val name:String? = null,
    val coord:CoordResponse? = null,
    val country:String? = null,
    val population:Long? = null
)