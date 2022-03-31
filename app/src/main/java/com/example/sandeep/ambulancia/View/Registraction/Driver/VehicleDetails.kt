package com.example.sandeep.ambulancia.View.Registraction.Driver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.sandeep.ambulancia.R
import com.example.sandeep.ambulancia.View.Registraction.RegistractionActivity
import com.example.sandeep.ambulancia.ViewModel.VehicleDetailsViewModel

class VehicleDetails : Fragment(), RegistractionActivity.IOnBackPressed {


    companion object {
        fun newInstance() = VehicleDetails()
    }

    private lateinit var viewModel: VehicleDetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.vehicle_details_fragment, container, false)

        view?.let {

        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val frag = requireActivity().supportFragmentManager
                frag.commit{

                    setReorderingAllowed(true)
                    replace(R.id.registractionPage,SelectionVehicles())

                }

            }
        })

        return view


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[VehicleDetailsViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onBackPressed(): Boolean {
        activity?.supportFragmentManager?.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        return true
    }


}