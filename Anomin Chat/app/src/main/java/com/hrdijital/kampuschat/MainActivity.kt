package com.hrdijital.kampuschat

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.hrdijital.kampuschat.databinding.ActivityMainBinding
import com.hrdijital.kampuschat.model.User
import com.hrdijital.kampuschat.utils.App


class MainActivity : AppCompatActivity() {

     lateinit var binding: ActivityMainBinding

   private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        App.toolbar = binding.ToolbarApp
        App.logo = binding.tolbarText
        App.user= User(null,null,null,null,null,null,null,null)
        setSupportActionBar(App.toolbar)

      /*  navigationController=Navigation.findNavController(ac,R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this,navigationController)*/




    }


  /*override fun onSupportNavigateUp(): Boolean {

        return NavigationUI.navigateUp(navigationController,null)
    }
*/

}