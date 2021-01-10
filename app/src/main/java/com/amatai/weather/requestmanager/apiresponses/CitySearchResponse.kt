package com.amatai.weather.requestmanager.apiresponses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CitySearchResponse (
    val name:String,
    val lat:Double,
    val lon:Double,
    val country:String
) : Parcelable