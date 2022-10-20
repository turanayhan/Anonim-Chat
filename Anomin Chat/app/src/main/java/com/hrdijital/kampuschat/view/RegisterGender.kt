package com.hrdijital.kampuschat.view

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.FragmentRegisterGenderBinding
import com.hrdijital.kampuschat.databinding.FragmentRegisterScreenBinding
import java.util.*


class RegisterGender : Fragment() {

    private lateinit var binding:FragmentRegisterGenderBinding
    private var greet:String?=null
    private lateinit var picker: DatePicker


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentRegisterGenderBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val today=Calendar.getInstance()
        picker=binding.datePicker

        picker.init(today.get(Calendar.YEAR),today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH)){
            view, year, month, day ->

            val month=month+1

            binding.datePickerBtn.text="${day} - ${month} - ${year}"
            binding.datePickerBtn.setTextColor((Color.parseColor("#604CE3")))

        }

        binding.constraintLayout3.setOnClickListener {

            binding.datePicker.visibility=View.GONE
        }







        binding.toggleBtn.addOnButtonCheckedListener { toggleBtn, checkedId, isChecked ->

            if (isChecked){

                when(checkedId){

                    R.id.woman -> woman()
                    R.id.men -> men()

                }


            }



        }


        binding.datePickerBtn.setOnClickListener {

            binding.datePicker.visibility=View.VISIBLE

        }



    }
    @SuppressLint("UseCompatTextViewDrawableApis")
    private fun men() {

        greet="Erkek"

        binding.men.setTextColor((Color.parseColor("#604CE3")))
        binding.men.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#604CE3"))
        binding.woman.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#C8CBCE"))
        binding.woman.setTextColor(Color.parseColor("#C8CBCE"))
    }

    @SuppressLint("UseCompatTextViewDrawableApis")
    private fun woman(){

        greet="Kadın"

        binding.woman.setTextColor(Color.parseColor("#604CE3"))
        binding.men.setTextColor((Color.parseColor("#C8CBCE")))
        binding.men.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#C8CBCE"))
        binding.woman.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#604CE3"))





    }



}


