package com.hrdijital.kampuschat.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.ActivityMainBinding
import com.hrdijital.kampuschat.databinding.FragmentHomeScreenBinding
import com.hrdijital.kampuschat.databinding.FragmentLoginScreenBinding
import com.hrdijital.kampuschat.utils.App


class HomeScreen : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding
    private lateinit var action: NavDirections


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentHomeScreenBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.toolbar_desing(null,Color.parseColor("#604CE3"),"Kampus", Color.parseColor("#FFFFFF"),Color.parseColor("#604CE3"),View.SYSTEM_UI_FLAG_LAYOUT_STABLE,requireActivity(),View.VISIBLE,View.VISIBLE)
        binding.btnCreateAccount.setOnClickListener {

            action=HomeScreenDirections.actionHomeScreenToRegisterScreen()
            Navigation.findNavController(it).navigate(action)

        }
        binding.loginBtn.setOnClickListener {
            action=HomeScreenDirections.actionHomeScreenToLoginScreen()
            Navigation.findNavController(it).navigate(action)
        }
    }




}