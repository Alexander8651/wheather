package com.amatai.weather.requestmanager.apiresponses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WindResponse (
    val speed:Float? = null,
    val deg:Float? = null
) : Parcelable