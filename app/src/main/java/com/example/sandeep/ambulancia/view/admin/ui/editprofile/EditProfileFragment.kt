package com.example.sandeep.ambulancia.view.admin.ui.editprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sandeep.ambulancia.databinding.FragmentEditprofileBinding

class EditProfileFragment : Fragment() {

    private var _binding: FragmentEditprofileBinding? = null
    private var name:EditText?=null
    private var email:EditText?=null
    private var phone:EditText?=null
    private var password:EditText?=null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(EditProfileViewModel::class.java)

        _binding = FragmentEditprofileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name=binding.edtName
        email=binding.edtEmail
        phone=binding.edtPhone
        phone=binding.edtPassword

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}