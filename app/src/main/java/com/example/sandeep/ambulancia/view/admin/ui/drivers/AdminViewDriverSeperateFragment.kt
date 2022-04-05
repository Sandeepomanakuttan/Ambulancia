package com.example.sandeep.ambulancia.view.admin.ui.drivers

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sandeep.ambulancia.databinding.FragmentAdminViewDriverSeperateBinding


class AdminViewDriverSeperateFragment : Fragment() {

    private var viewModel:AdminViewDriversViewModel?=null
    private var _binding:FragmentAdminViewDriverSeperateBinding?=null
    private var recyclerView:RecyclerView?=null

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentAdminViewDriverSeperateBinding.inflate(inflater, container, false)

        return _binding!!.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModel= ViewModelProvider(this)[AdminViewDriversViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=binding.recyclerView
        initializeAdaptor()
    }

    private fun initializeAdaptor() {
        recyclerView?.layoutManager=LinearLayoutManager(requireContext())

    }
}