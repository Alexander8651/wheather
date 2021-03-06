package com.amatai.weather.requestmanager.apiresponses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SysResponse (
    val country:String? = null,
    val sunrise:Long? = null,
    val sunset:Long? = null
) : Parcelable