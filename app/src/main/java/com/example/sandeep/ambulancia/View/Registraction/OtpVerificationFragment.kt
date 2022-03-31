package com.example.sandeep.ambulancia.View.Registraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.sandeep.ambulancia.R
import com.example.sandeep.ambulancia.View.Registraction.Driver.SelectionVehicles
import com.example.sandeep.ambulancia.ViewModel.OtpViewModel

class OtpVerificationFragment : Fragment() {

    companion object {
        fun newInstance() = OtpVerificationFragment()
    }

    private lateinit var viewModel: OtpViewModel
    private lateinit var btnVerify:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         val view=inflater.inflate(R.layout.main_fragment, container, false)

            view?.let {
                btnVerify=view.findViewById(R.id.btnVerify)

                btnVerify.isVisible=true

                btnVerify.setOnClickListener {

                    requireActivity().supportFragmentManager.commit {
                        btnVerify.isVisible=false
                        replace(R.id.otp_verification,SelectionVehicles())
                        setReorderingAllowed(true)
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OtpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}