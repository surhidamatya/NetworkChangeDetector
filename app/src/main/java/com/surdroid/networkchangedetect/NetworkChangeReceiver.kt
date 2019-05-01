package com.surdroid.networkchangedetect

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val status = context.getConnectivityStatusString()

        Toast.makeText(context, status, Toast.LENGTH_SHORT).show()
    }
}
