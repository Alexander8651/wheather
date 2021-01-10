package com.amatai.weather.requestmanager.apiresponses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherResponse (
    val description:String? = null
) : Parcelable