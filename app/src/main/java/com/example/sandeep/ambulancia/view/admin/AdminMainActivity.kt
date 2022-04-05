package com.example.sandeep.ambulancia.view.admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.sandeep.ambulancia.R
import com.example.sandeep.ambulancia.databinding.ActivityAdminMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class AdminMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_admin_main)
        navView.setupWithNavController(navController)
    }
}