package com.amatai.weather.requestmanager.apiresponses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.lang.NullPointerException

@Parcelize
data class MainResponses(
    val temp:Double? = null,
    val feels_like:Float? = null,
    val temp_min:Float? = null,
    val temp_max:Float? = null,
    val pressure:Float? = null,
    val humidity:Float? = null
) : Parcelable