package com.hrdijital.kampuschat.view

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.FragmentLoginScreenBinding
import com.hrdijital.kampuschat.utils.App
import com.hrdijital.kampuschat.utils.PreferencesManager


class LoginScreen : Fragment() {

    private lateinit var binding: FragmentLoginScreenBinding
    private lateinit var auth:FirebaseAuth
    private lateinit var loginMail:String
    private lateinit var loginPassword:String
    private lateinit var action:NavDirections



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth= FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding=FragmentLoginScreenBinding.inflate(inflater,container,false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.toolbar_desing(R.drawable.arrow_back,Color.parseColor("#604CE3"),"Kampus",Color.parseColor("#FFFFFF"),Color.parseColor("#604CE3"),View.SYSTEM_UI_FLAG_LAYOUT_STABLE,requireActivity(),View.VISIBLE,View.VISIBLE)
        App.manager= PreferencesManager(requireActivity())
        buttonControl()





    }





    fun buttonControl(){

        binding.loginBtn.setOnClickListener { _view: View? ->

            loginMail=binding.loginMail.text.toString()
            loginPassword=binding.loginPassword.text.toString()



            if (loginMail.trim().equals("")||loginPassword.trim().equals("")){
                Toast.makeText(requireActivity(), "Lütfen eksik yerleri doldurunuz", Toast.LENGTH_SHORT).show()
            }
            else{

                auth.signInWithEmailAndPassword(loginMail,loginPassword).addOnCompleteListener {

                    if (it.isSuccessful){
                        App.manager!!.setLoginState(true)
                        navControl(_view!!)

                    }
                    else{

                        Toast.makeText(requireActivity(), "Bilgilerinizi kontrol ediniz", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }


        binding.resetPassword.setOnClickListener {


        }

    }

    fun navControl(view:View){


        action=LoginScreenDirections.actionLoginScreenToChat()
        Navigation.findNavController(view).navigate(action)
    }

}