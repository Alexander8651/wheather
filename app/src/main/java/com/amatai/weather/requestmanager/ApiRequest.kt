package com.amatai.weather.requestmanager

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val BASE_ROOT = "http://api.openweathermap.org/"

val interceptor:HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    this.level = HttpLoggingInterceptor.Level.BODY
}

val client:OkHttpClient = OkHttpClient.Builder().apply {
    this.addInterceptor(interceptor)
    this.readTimeout(20, TimeUnit.SECONDS)
    connectTimeout(10, TimeUnit.SECONDS)
}.build()



private val retrofit = Retrofit.Builder()
    .client(client)
    .baseUrl(BASE_ROOT)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

object RetrofitService{
    val retrofitService:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}