package com.example.athakar.ui.main.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.work.*
import com.example.athakar.R
import com.example.athakar.ui.main.myworker.Myworker
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //to hide statusa bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        var sharedPreferences = this.getSharedPreferences("myPref", MODE_PRIVATE)
        var language = sharedPreferences.getString("MyLang", "")
        language.let {
            setLocale(language!!)
        }


        val navController=findNavController(R.id.fragmentContainerView)

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination , _ ->
            when (destination.id) {
                R.id.loginFragment -> bottomNavigationView.visibility = View.GONE
                R.id.sigupFragment -> bottomNavigationView.visibility = View.GONE
                else -> bottomNavigationView.visibility = View.VISIBLE
            }

        }

myWorkerManger()

    }

    private fun myWorkerManger() {

        val constraints = Constraints.Builder()
            .setRequiresCharging(false)
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresCharging(false)
            .setRequiresBatteryNotLow(true)
            .build()
        val myRequest = PeriodicWorkRequest.Builder(
            Myworker::class.java,15, TimeUnit.DAYS
        ).setConstraints(constraints)
            .build()
        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork("my_id", ExistingPeriodicWorkPolicy.KEEP,myRequest)
    }


    fun setLocale(lang: String) {

        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        this.resources.updateConfiguration(
            config,
            this.resources.displayMetrics
        )

        val myPref = this.getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = myPref.edit()

        editor.putString("MyLang", lang)
        editor.commit()
    }



}