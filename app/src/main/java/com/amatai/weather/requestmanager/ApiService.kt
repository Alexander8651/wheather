package com.amatai.weather.requestmanager

import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("geo/1.0/direct")
    fun getCities(@Query("q") city:String,
    @Query("limit") limit:Int, @Query("appid") appid:String,@Query("units") metric:String):Deferred<List<CitySearchResponse>>

}