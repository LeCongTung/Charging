package com.example.charging.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.charging.toast

class ChargingReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val isCharging = p1?.action.equals(Intent.ACTION_POWER_CONNECTED)

//        Log.d("battery", isCharging.toString())
//        isCharging.toString().toast(p0)
        if (isCharging) {
            "Start charging".toast(p0)
        } else {
            "Stop charging".toast(p0)
        }
    }
}