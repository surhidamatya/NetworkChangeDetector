package com.surdroid.networkchangedetect

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import com.surdroid.networkchangedetect.NetworkType.MOBILE
import com.surdroid.networkchangedetect.NetworkType.NOT_CONNECTED
import com.surdroid.networkchangedetect.NetworkType.WIFI


fun Context.getConnectivityStatus(): Int {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return when (cm.activeNetworkInfo.type) {
        ConnectivityManager.TYPE_WIFI -> WIFI
        ConnectivityManager.TYPE_MOBILE -> MOBILE
        else -> NOT_CONNECTED
    }
}

fun Context.getConnectivityStatusString(): String? {
    return when (getConnectivityStatus()) {
        WIFI -> "Wifi enabled"
        MOBILE -> "Mobile data enabled"
        NOT_CONNECTED -> "Not connected to Internet"
        else -> null
    }
}

fun Context.getSSIDList(): List<String> {
    /*
     * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
     * Check this permission in manifest
     * */
    val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    return wifiManager.configuredNetworks.map { it.SSID }
}

object NetworkType {
    var WIFI = 1
    var MOBILE = 2
    var NOT_CONNECTED = 0
}
