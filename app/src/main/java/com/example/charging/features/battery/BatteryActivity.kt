package com.example.charging.features.battery

import android.os.BatteryManager
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.charging.databinding.ActivityBatteryBinding

class BatteryActivity : AppCompatActivity(){

    private lateinit var binding: ActivityBatteryBinding
    var handler: Handler = Handler()
    var runnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBatteryBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()

//        Mo comment ham ni de sau 5 giay tu dong tat
//        Handler().postDelayed({
//            finish()
//        }, 5000)

        handler.postDelayed(Runnable {
            handler.postDelayed(runnable!!, 500)
            val bm = applicationContext.getSystemService(BATTERY_SERVICE) as BatteryManager
            val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            binding.batteryLabel.text = "$batLevel%"
        }.also { runnable = it }, 500)
    }
}

