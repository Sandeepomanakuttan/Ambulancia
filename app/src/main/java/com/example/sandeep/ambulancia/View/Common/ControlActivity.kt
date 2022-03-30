package com.example.sandeep.ambulancia.View.Common

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sandeep.ambulancia.databinding.ActivityControlBinding

class ControlActivity : AppCompatActivity() {

     lateinit var binding: ActivityControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsingIn.setOnClickListener {
            startActivity(Intent(this,LoginPage::class.java))

        }
    }
}