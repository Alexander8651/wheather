package com.amatai.weather.requestmanager.apiresponses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityDataResponse(
    val coord: CoordResponse? = null,
    val main: MainResponses? = null,
    val wind: WindResponse? = null,
    val clouds: CloudsResponse? = null,
    val sys: SysResponse,
    val dt: Long? = null,
    val name: String? = null,
    val cod: Int? = null,
    val weather:List<WeatherResponse>? = null
) : Parcelable