
package com.example.sandeep.ambulancia.view.registraction.Driver

import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.sandeep.ambulancia.R
import com.example.sandeep.ambulancia.ViewModel.RegViewModel
import com.example.sandeep.ambulancia.databinding.ActivityRegistractionBinding
import com.example.sandeep.ambulancia.model.registraction.DriversData

class RegistractionActivity : AppCompatActivity() {


    private var bind: ActivityRegistractionBinding?=null

    private var firstName:EditText?=null
    private var secondName:EditText?=null
    private var phoneNumber:EditText?=null
    private var city:EditText?=null
    private var password:EditText?=null
    private var conformpassword:EditText?=null
    private var checked:CheckBox?=null

    lateinit var viewModel:RegViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityRegistractionBinding.inflate(layoutInflater)
        setContentView(bind?.root)

        firstName=bind?.edtFirstName
        secondName=bind?.edtLastName
        phoneNumber=bind?.edtPhone
        city=bind?.edtCity
        password=bind?.etdPassword
        conformpassword=bind?.etdConPassword
        checked=bind?.checkBox

        bind?.btnNext?.setOnClickListener {

            val firstName = firstName?.text.toString()
            val secondName = secondName?.text.toString()
            val phoneNumber = phoneNumber?.text?.trim().toString()
            val city = city?.text.toString()
            val password = password?.text.toString()
            val conformpassword = conformpassword?.text.toString()

            viewModel=ViewModelProvider(this)[RegViewModel()::class.java]

            viewModel.s=this



            when {
                firstName.isBlank() -> {

                    Toast.makeText(this, "Enter your First Name", Toast.LENGTH_SHORT).show()
                }
                secondName.isBlank() -> {

                    Toast.makeText(this, "Enter your Second Name", Toast.LENGTH_SHORT).show()
                }
                phoneNumber.isBlank() -> {

                    Toast.makeText(this, "Enter your Phone Number", Toast.LENGTH_SHORT).show()
                }
                phoneNumber.length!=10->{

                    Toast.makeText(this, "phone number must be 10 digit", Toast.LENGTH_SHORT).show()
                }
                city.isBlank() -> {

                    Toast.makeText(this, "Enter your City", Toast.LENGTH_SHORT).show()
                }
                password.isBlank() -> {

                    Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show()
                }
                conformpassword.isBlank() -> {

                    Toast.makeText(this, "Enter your reEnter Password", Toast.LENGTH_SHORT).show()
                }
                password != conformpassword -> {

                    Toast.makeText(this, "Password Not Match", Toast.LENGTH_SHORT).show()

                }

                !checked!!.isChecked->{

                    Toast.makeText(this, "please read and agree term & condition", Toast.LENGTH_SHORT).show()

                }
                else -> {
                            val data =
                                DriversData(firstName, secondName, phoneNumber, city, password)
                    viewModel.sendVerificationCode(phoneNumber)

                    viewModel.otps?.observe(this) {

                        supportFragmentManager.beginTransaction().replace(
                            R.id.registractionPage,
                            OtpVerificationFragment(data, it.toString())
                        ).commit()

                    }

                    }



                }
            }




        }
    


    interface IOnBackPressed {
        fun onBackPressed(): Boolean
    }
}