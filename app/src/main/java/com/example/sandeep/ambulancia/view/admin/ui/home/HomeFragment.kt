package com.example.sandeep.ambulancia.view.admin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sandeep.ambulancia.databinding.FragmentHomeBinding
import de.hdodenhof.circleimageview.CircleImageView

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private var profileImg:CircleImageView?=null
    private var name:TextView?=null
    private var email:TextView?=null
    private var phone:TextView?=null
    private var password:TextView?=null
    private var total:TextView?=null
    private var request:TextView?=null
    private var cancel:TextView?=null
    private var homeViewModel:HomeViewModel?=null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileImg=binding.imgProfile
        name=binding.txtName
        email=binding.txtEmail
        phone=binding.txtPhone
        password=binding.txtPassword
        total= binding.txtTotal
        request=binding.txtRequest
        cancel=binding.txtCancel

        getProfileDetails()


    }

    private fun getProfileDetails() {

//        homeViewModel?.text?.observe(viewLifecycleOwner) {
//
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}