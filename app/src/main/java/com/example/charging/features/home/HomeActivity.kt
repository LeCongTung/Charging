package com.example.charging.features.home

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.charging.R
import com.example.charging.broadcast.ChargingReceiver
import com.example.charging.databinding.ActivityHomeBinding
import com.example.charging.service.ChargingService

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startService(Intent(this, ChargingService::class.java))
    }

    override fun onResume() {
        super.onResume()
        initEventListener()

    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this, ChargingService::class.java))
    }

    private fun initEventListener(){


        val bm = applicationContext.getSystemService(BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        binding.statusTextView.text = "Battery is $batLevel%"
    }
}