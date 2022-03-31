package com.example.sandeep.ambulancia.View.Common

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sandeep.ambulancia.View.Registraction.RegistractionActivity
import com.example.sandeep.ambulancia.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    var binding:ActivityLoginPageBinding?=null

    override fun onBackPressed() {
        super.onBackPressed()
        onDestroy()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.txtRegister?.setOnClickListener {
            startActivity(Intent(this,RegistractionActivity::class.java))
        }
    }
}