package com.amatai.weather.requestmanager.apiresponses

data class CityDataResponse(
    val coord:CoordResponse? = null,
    val main:MainResponses? = null,
    val wind:WindResponse? = null,
    val clouds:CloudsResponse? = null,
    val sys:SysResponse,
    val dt:Long? = null,
    val name:String? = null,
    val cod:Int? = null
)