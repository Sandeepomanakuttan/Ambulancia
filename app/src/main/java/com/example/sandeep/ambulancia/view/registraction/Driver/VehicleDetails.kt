package com.example.sandeep.ambulancia.view.registraction.Driver

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sandeep.ambulancia.R
import com.example.sandeep.ambulancia.ViewModel.VehicleDetailsViewModel
import com.example.sandeep.ambulancia.model.registraction.DriversData

class VehicleDetails(val data: DriversData, val vehicleType: String) : Fragment(),RegRecyclerview.Image,RegistractionActivity.IOnBackPressed {


    companion object {
        fun newInstance() = RegistractionActivity()
    }

    private lateinit var viewModel: VehicleDetailsViewModel
    private lateinit var recyclerGet:RecyclerView;
    private var viewManager = LinearLayoutManager(requireContext())
    private lateinit var recyclerPending:RecyclerView
    private lateinit var recyclerCompleted:RecyclerView
    private var uri:String?=null
    private var unicdata:ProfileImage?=null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.vehicle_details_fragment, container, false)

        view?.let {

            viewModel.addDriver(data)
            viewModel.addDetail("Profile Image","","Get started")
            viewModel.addDetail("Driving License","","Get started")
            viewModel.addDetail("Rc Book","","Get started")
            viewModel.addDetail("Insurance","","Get started")
            viewModel.addDetail("Road Tax","","Get started")


            initialiseAdapter()

            viewModel.vehicleStatusList.observe(requireActivity()){

            }

        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val frag = requireActivity().supportFragmentManager
                frag.commit{

                    setReorderingAllowed(true)
                    replace(R.id.registractionPage,SelectionVehicles(data))

                }

            }
        })

        return view


    }

    private fun initialiseAdapter() {
        recyclerGet.layoutManager=viewManager
        viewModel.retriveData("Get started")
        recyclerPending.layoutManager=viewManager
        viewModel.retriveData("Pending")
        recyclerCompleted.layoutManager=viewManager
        viewModel.retriveData("Completed")

        observerData()
    }

    private fun observerData() {
        viewModel.vehicleStatusList.observe(requireActivity()){
            recyclerGet.adapter=RegRecyclerview(requireActivity(),it,this)
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this)[VehicleDetailsViewModel::class.java]

    }

    override fun openGalary(data: ProfileImage) {
        unicdata=data
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, 1002)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            if (requestCode==1002 && resultCode==Activity.RESULT_OK){
                 uri= data?.data?.toString()


                viewModel.addDetail(unicdata?.fileldName!!,uri!!,"Process")
            }
    }

    override fun onBackPressed(): Boolean {
        activity?.supportFragmentManager?.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        return true
    }


}