package com.example.sandeep.ambulancia.view.Common

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sandeep.ambulancia.databinding.ActivityControlBinding
import com.example.sandeep.ambulancia.view.registraction.Driver.RegistractionActivity

class ControlActivity : AppCompatActivity() {

     lateinit var binding: ActivityControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsingIn.setOnClickListener {
            startActivity(Intent(this,LoginPage::class.java))

        }

        binding.btnRegister.setOnClickListener {

            startActivity(Intent(this, RegistractionActivity::class.java))
            finish()
        }
    }
}