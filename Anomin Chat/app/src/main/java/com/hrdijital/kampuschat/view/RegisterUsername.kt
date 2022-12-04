package com.hrdijital.kampuschat.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.FragmentRegisterScreenBinding
import com.hrdijital.kampuschat.databinding.FragmentRegisterUsernameBinding
import com.hrdijital.kampuschat.utils.App


class RegisterUsername : Fragment() {

    private lateinit var binding:FragmentRegisterUsernameBinding
    private lateinit var action:NavDirections


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding=FragmentRegisterUsernameBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.toolbar_desing(R.drawable.arrow_back,
            Color.parseColor("#604CE3"),"Kampus",
            Color.parseColor("#FFFFFF"),
            Color.parseColor("#604CE3"),View.SYSTEM_UI_FLAG_LAYOUT_STABLE,requireActivity(),View.VISIBLE,View.VISIBLE)

        binding.registerBtn.setOnClickListener {
            binding.idPBLoading.visibility=View.VISIBLE

            if (binding.registerUsername.text.toString().trim().equals("")||binding.regsiterDescription.text.toString().trim().equals("")){
                binding.idPBLoading.visibility=View.GONE
                Toast.makeText(requireActivity(), "Lütfen eksik yerleri doldurunuz", Toast.LENGTH_SHORT).show()

            }
            else{

                App.user.userName=binding.registerUsername.text.toString()
                App.user.description=binding.regsiterDescription.text.toString()
                binding.idPBLoading.visibility=View.GONE
                action=RegisterUsernameDirections.actionRegisterUsernameToRegisterGender()
                Navigation.findNavController(view).navigate(action)

            }

        }




    }

}