package com.amatai.weather.requestmanager.apiresponses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CoordResponse (
    val lat:Double? = null,
    val lon:Double? = null
) : Parcelable