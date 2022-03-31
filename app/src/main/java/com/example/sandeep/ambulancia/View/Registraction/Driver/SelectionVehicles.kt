package com.example.sandeep.ambulancia.View.Registraction.Driver

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.example.sandeep.ambulancia.R
import com.example.sandeep.ambulancia.ViewModel.SelectedVehicleViewModel


class SelectionVehicles : Fragment() , LifecycleObserver {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    lateinit var viewModel:SelectedVehicleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_selection_vehicles, container, false)

        view?.let {
            val mini = view.findViewById(R.id.mini) as CardView

            mini.setOnClickListener {

                val frag = requireActivity().supportFragmentManager
                        frag.commit{
                            replace(R.id.registractionPage,VehicleDetails())
                            setReorderingAllowed(true)

                        }

            }

            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object :OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    requireActivity().supportFragmentManager.commit {
                        val alertDialog=AlertDialog.Builder(requireContext())
                        alertDialog.setTitle("Are you Sure")
                        alertDialog.setMessage("Do you to Cancel..its lose all data")
                        alertDialog.setPositiveButton("Yes"
                        ) { _, _ ->
                            activity?.finish()
                        }
                        alertDialog.setNegativeButton("No"){ _, _ ->

                        }
                        alertDialog.show()
                    }

                }
            })
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel= ViewModelProvider(this)[SelectedVehicleViewModel::class.java]

    }


}