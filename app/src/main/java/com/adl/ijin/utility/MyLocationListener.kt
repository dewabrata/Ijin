package com.adl.ijin.utility

import android.location.Location

interface MyLocationListener {
    fun onLocationChanged(location: Location)
}