package com.hrdijital.kampuschat.view

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.utils.App
import com.hrdijital.kampuschat.utils.PreferencesManager


class SplashScreen : Fragment() {

    private lateinit var action:NavDirections


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.toolbarVisibility(View.GONE)




        App.manager= PreferencesManager(requireActivity())

        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                //sayfa geçişlerinde kullanıyoruz.

                if (App.manager!!.getLoginState()){

                    action=SplashScreenDirections.actionSplashScreenToHomeScreen()
                    Navigation.findNavController(view).navigate(action)

                }
                else{
                    action=SplashScreenDirections.actionSplashScreenToHomeScreen()
                    Navigation.findNavController(view).navigate(action)

                }


            }
        }.start()



    }

}