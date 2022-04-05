package com.example.sandeep.ambulancia.view.admin.ui.drivers

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sandeep.ambulancia.R

class AdDriverFragment : Fragment() {

    companion object {
        fun newInstance() = AdDriverFragment()
    }

    private lateinit var viewModel: AdDriverViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ad_driver_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this)[AdDriverViewModel::class.java]

    }


}