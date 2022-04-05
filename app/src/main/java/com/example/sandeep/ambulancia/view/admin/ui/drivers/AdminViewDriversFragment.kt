package com.example.sandeep.ambulancia.view.admin.ui.drivers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.sandeep.ambulancia.databinding.FragmentAdminViewDriversBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AdminViewDriversFragment : Fragment() {

    private var _binding: FragmentAdminViewDriversBinding? = null
    private var tabLayout:TabLayout?=null
    private var viewPager:ViewPager2?=null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAdminViewDriversBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout=binding.tabLayout
        viewPager=binding.pager

        val adapter = AdminViewAdaptor(activity)
        adapter.addFragment(AdminViewDriverSeperateFragment(), "Drivers")
        adapter.addFragment(AdminRequestDriverViewFragment(), "Request")

        viewPager!!.adapter = adapter
        viewPager!!.currentItem = 0
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = adapter.getTabTitle(position)
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}