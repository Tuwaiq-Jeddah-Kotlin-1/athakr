package com.example.athakar.ui.main.qablah

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.athakar.R
import com.example.athakar.databinding.ActivityQublahBinding

class QublahActivity : AppCompatActivity() {

    lateinit var binding:ActivityQublahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        //to hide statusa bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding = ActivityQublahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        LocalBroadcastManager.getInstance(this).registerReceiver(
            broadcastReceiver, IntentFilter(SensorService.onsensor_changed_action_key)
        )

    }

    override fun onResume() {
        super.onResume()
        startForegroundServiceForCompassSensor(false)
    }

    private fun startForegroundServiceForCompassSensor(background: Boolean) {
        val compassSensorIntent = Intent(this, SensorService::class.java)
        compassSensorIntent.putExtra(SensorService.background_key, background)
        ContextCompat.startForegroundService(this, compassSensorIntent)
    }

    override fun onPause() {
        super.onPause()
        startForegroundServiceForCompassSensor(true)
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver)
        super.onDestroy()
    }

    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val direction = intent.getStringExtra(SensorService.direction_key)
            val angle = intent.getDoubleExtra(SensorService.angle_key, 0.0)
            val angleWithDirection = "$angle  $direction"

            binding.directionTextView.text = angleWithDirection
            binding.imgCompass.rotation = angle.toFloat() * -1
        }
    }
}
