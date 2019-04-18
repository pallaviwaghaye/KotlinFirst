package com.webakruti.kotlinfirst

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by DELL on 1/30/2019.
 */
class NetworkUtil {
    fun hasConnectivity(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }

}