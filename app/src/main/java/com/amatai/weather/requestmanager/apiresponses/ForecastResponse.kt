package com.amatai.weather.requestmanager.apiresponses


data class ForecastResponse (
    val dt_txt:String? = null,
    val main:MainResponses? = null,
    val weather:List<WeatherResponse>? = null
)