package com.example.sandeep.ambulancia.View.Common

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.sandeep.ambulancia.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var viewBind:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,ControlActivity::class.java))
            finish()
        },3000)
    }
}