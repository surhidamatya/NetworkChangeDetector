package com.surdroid.networkchangedetect

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val status = NetworkUtil.getConnectivityStatusString(context)

        Toast.makeText(context, status, Toast.LENGTH_SHORT).show()
    }
}
