package com.hrdijital.kampuschat.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.adapter.MessageAdapter
import com.hrdijital.kampuschat.adapter.UserAdapter
import com.hrdijital.kampuschat.adapter.UserAdapterActive

import com.hrdijital.kampuschat.databinding.FragmentSettingsBinding
import com.hrdijital.kampuschat.utils.App




class Settings : Fragment() {

    lateinit var binding: FragmentSettingsBinding
    private  var messageAdapter: MessageAdapter = MessageAdapter(arrayListOf())




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSettingsBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.toolbarText.text = "Ayarlar"













    }
}