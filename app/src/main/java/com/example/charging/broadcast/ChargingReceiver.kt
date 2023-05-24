package com.example.charging.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.charging.features.battery.BatteryActivity
import com.example.charging.features.home.HomeActivity
import com.example.charging.toast

class ChargingReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val isCharging = p1?.action.equals(Intent.ACTION_POWER_CONNECTED)

        if (isCharging) {
            "Start charging".toast(p0)
            val intent = Intent(p0, BatteryActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            p0?.startActivity(intent)
        } else {
            "Stop charging".toast(p0)
        }
    }
}