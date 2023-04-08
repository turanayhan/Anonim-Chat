package com.hrdijital.kampuschat.view



import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.rpc.context.AttributeContext.Resource
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.FragmentChatBinding
import com.hrdijital.kampuschat.databinding.FragmentHomeScreenBinding
import com.hrdijital.kampuschat.utils.App


class Chat : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private lateinit var navController1: NavController
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentChatBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.toolbarText=binding.toolbarTitle
        binding.bottomNav.background=null



        App.toolbarVisibility(View.GONE)
        requireActivity().window.statusBarColor= ContextCompat.getColor(requireActivity(),R.color.black)



        //bottom menu
        navController1=findNavController(requireActivity(),R.id.fragment2)
        binding.bottomNav.setupWithNavController(navController1)

        navController=Navigation.findNavController(view)
        var config=
            AppBarConfiguration.Builder(navController.graph).setDrawerLayout(binding.drawerLayout).build()
        NavigationUI.setupWithNavController(binding.navView,navController)
        NavigationUI.setupWithNavController(binding.toolbar,navController,config)





    }





}