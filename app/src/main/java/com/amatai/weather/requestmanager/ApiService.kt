package com.amatai.weather.requestmanager

import com.amatai.weather.requestmanager.apiresponses.CityDataResponse
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse
import com.amatai.weather.requestmanager.apiresponses.ForecastResponse
import com.amatai.weather.requestmanager.apiresponses.ListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("geo/1.0/direct")
    fun getCities(@Query("q") city:String,
    @Query("limit") limit:Int, @Query("appid") appid:String,@Query("units") metric:String):Deferred<List<CitySearchResponse>>

    @GET("data/2.5/weather?")
    fun getCityData(@Query("lat") lat:Double,
                      @Query("lon") lon:Double,@Query("appid") appid:String,
                    @Query("units") metric:String):Deferred<CityDataResponse>

    @GET("data/2.5/forecast?")
    fun forecastData(@Query("lat") lat:Double,
                      @Query("lon") lon:Double,@Query("appid") appid:String,@Query("cnt") cnt:Int,
                    @Query("units") metric:String):Deferred<ListResponse>

}