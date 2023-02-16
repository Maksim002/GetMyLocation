package com.example.mylacation

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager

@SuppressLint("MissingPermission")
fun getBestLocation(context: Context): Location? {
    val value = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val providers = value.getProviders(true)
    var bestLoc: Location? = null
    for (arr in providers) {
        val local = value.getLastKnownLocation(arr) ?: continue
        if (bestLoc == null || local.accuracy < bestLoc.accuracy) bestLoc = local
    }
    return bestLoc
}