package com.example.sandeep.ambulancia.view.registraction.Driver

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.sandeep.ambulancia.R
import com.example.sandeep.ambulancia.ViewModel.OtpViewModel
import com.example.sandeep.ambulancia.model.registraction.DriversData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider

class OtpVerificationFragment(var data: DriversData, private val s: String) : Fragment() {


    private lateinit var viewModel: OtpViewModel
    private lateinit var btnVerify:Button
    private lateinit var phone: TextView
    private lateinit var code1: EditText
    private lateinit var code2: EditText
    private lateinit var code3: EditText
    private lateinit var code4: EditText
    private lateinit var code5: EditText
    private lateinit var code6: EditText
    private lateinit var verificationId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         val view=inflater.inflate(R.layout.main_fragment, container, false)

            view?.let {
                btnVerify=view.findViewById(R.id.btnVerify)
                phone=view.findViewById(R.id.txtPhone)
                code1=view.findViewById(R.id.code1)
                code2=view.findViewById(R.id.code2)
                code3=view.findViewById(R.id.code3)
                code4=view.findViewById(R.id.code4)
                code5=view.findViewById(R.id.code5)
                code6=view.findViewById(R.id.code6)
                verificationId=s

                Toast.makeText(requireContext(), verificationId, Toast.LENGTH_SHORT).show()


                setupOTPinput()
                phone.text=data.phoneNumber
                btnVerify.isVisible=true

                btnVerify.setOnClickListener {

                    if (code1.text.toString().trim { it <= ' ' }.isEmpty()
                        || code2.text.toString().trim { it <= ' ' }.isEmpty()
                        || code3.text.toString().trim { it <= ' ' }.isEmpty()
                        || code4.text.toString().trim { it <= ' ' }.isEmpty()
                        || code5.text.toString().trim { it <= ' ' }.isEmpty()
                        || code6.text.toString().trim { it <= ' ' }.isEmpty()
                    ) {
                        Toast.makeText(
                            requireContext(),
                            "Please Enter Valid code",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                    val code: String = (code1.text.toString()
                            + code2.text.toString() +
                            code3.text.toString() +
                            code4.text.toString() +
                            code5.text.toString() +
                            code6.text.toString())

                    if (verificationId.isNotEmpty()) {
                        Toast.makeText(requireContext(), verificationId, Toast.LENGTH_SHORT).show()
                        val phoneAuthcredential = PhoneAuthProvider.getCredential(
                            verificationId, code
                        )

                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthcredential).addOnCompleteListener {

                            if (it.isSuccessful){

                                requireActivity().supportFragmentManager.commit {

                                    btnVerify.isVisible = false
                                    replace(R.id.otp_verification, SelectionVehicles(data))
                                    setReorderingAllowed(true)

                                }
                                
                            }else{
                                Toast.makeText(requireContext(), "Invalid otp", Toast.LENGTH_SHORT).show()
                            }
                        }


                    }



                    

                }

                requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object :OnBackPressedCallback(true){
                    override fun handleOnBackPressed() {
                        requireActivity().supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            remove(this@OtpVerificationFragment)
                        }
                    }
                })
            }
            return view

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this)[OtpViewModel::class.java]

    }

    private fun setupOTPinput() {
        code1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isNotEmpty()) {
                    code2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        code2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isNotEmpty()) {
                    code3.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        code3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isNotEmpty()) {
                    code4.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
       code4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isNotEmpty()) {
                   code5.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        code5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isNotEmpty()) {
                    code6.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

}