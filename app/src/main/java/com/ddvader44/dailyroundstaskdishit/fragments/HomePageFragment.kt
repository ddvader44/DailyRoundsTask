package com.ddvader44.dailyroundstaskdishit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ddvader44.dailyroundstaskdishit.R
import com.ddvader44.dailyroundstaskdishit.databinding.FragmentHomePageBinding
import com.ddvader44.dailyroundstaskdishit.viewmodels.LoginViewModel

class HomePageFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val logOutButton = binding.logOut
        logOutButton.setOnClickListener {
            loginViewModel.logout()
        }
    }

}