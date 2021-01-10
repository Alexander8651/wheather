package com.amatai.weather.requestmanager.apiresponses

data class ListResponse (
    val cod:String? = null,
    val list:List<ForecastResponse>
)