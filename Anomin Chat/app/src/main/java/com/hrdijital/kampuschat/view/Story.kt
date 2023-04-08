package com.hrdijital.kampuschat.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.FragmentSettingsBinding
import com.hrdijital.kampuschat.databinding.FragmentStoryBinding
import com.hrdijital.kampuschat.utils.App


class Story : Fragment() {

    lateinit var binding: FragmentStoryBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding= FragmentStoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }

    override fun onResume() {
        super.onResume()

        App.toolbarText.text="Hikayeler"
    }




}