package com.amatai.weather.requestmanager.apiresponses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CloudsResponse (
    val all:Float? = null
) : Parcelable