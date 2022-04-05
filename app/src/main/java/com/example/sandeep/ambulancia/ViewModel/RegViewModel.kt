package com.example.sandeep.ambulancia.ViewModel

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit


class RegViewModel() : ViewModel() {

    var otps:MutableLiveData<String>?=null
        @SuppressLint("StaticFieldLeak")
        var s: Activity?=null

    init {
        otps=MutableLiveData()
    }
    var mauth = FirebaseAuth.getInstance()



     fun sendVerificationCode(phoneNumber: String) {
        val fullnumber = "+91$phoneNumber"
        val options = PhoneAuthOptions.newBuilder(mauth)
            .setPhoneNumber(fullnumber)
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(s!!) // Activity (for callback binding)
            .setCallbacks(mCallbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

      private val  mCallbacks :PhoneAuthProvider.OnVerificationStateChangedCallbacks= object :PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
         override fun onVerificationCompleted(p0: PhoneAuthCredential) {
             Toast.makeText(s , "verification completed", Toast.LENGTH_SHORT).show()
         }

         override fun onVerificationFailed(p0: FirebaseException) {
             Toast.makeText(s, "faild", Toast.LENGTH_SHORT).show()
         }

          override fun onCodeSent(
              verificationId: String,
              token: PhoneAuthProvider.ForceResendingToken
          ) {
              super.onCodeSent(verificationId, token)
              otps?.value = verificationId
          }

     }


}