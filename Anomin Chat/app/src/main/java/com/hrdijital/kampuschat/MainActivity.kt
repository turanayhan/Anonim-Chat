package com.hrdijital.kampuschat

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.hrdijital.kampuschat.databinding.ActivityMainBinding
import com.hrdijital.kampuschat.utils.App


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

   // private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        App.toolbar = binding.ToolbarApp
        App.toolbar_text = binding.tolbarText
        setSupportActionBar(App.toolbar)

//       navigationController=Navigation.findNavController(this,R.id.fragmentContainerViews)
  //      NavigationUI.setupActionBarWithNavController(this,navigationController)




    }

  /* override fun onSupportNavigateUp(): Boolean {

        return NavigationUI.navigateUp(navigationController,null)
    }*/


}