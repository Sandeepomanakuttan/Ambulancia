
package com.example.sandeep.ambulancia.Registraction

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.sandeep.ambulancia.R
import com.example.sandeep.ambulancia.databinding.ActivityRegistractionBinding

class RegistractionActivity : AppCompatActivity() {
    var bind:ActivityRegistractionBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bind= ActivityRegistractionBinding.inflate(layoutInflater)
        setContentView(bind?.root)

        bind?.btnNext?.setOnClickListener {

            supportFragmentManager.beginTransaction().replace(R.id.registractionPage,SelectionVehicles()).commit()

        }

    }
}