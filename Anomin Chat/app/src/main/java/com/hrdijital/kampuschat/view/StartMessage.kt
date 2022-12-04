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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.FragmentStartMessageBinding
import com.hrdijital.kampuschat.utils.App


class StartMessage : Fragment() {

    private lateinit var dbUser:FirebaseFirestore
    private lateinit var mAuth: FirebaseAuth
    private lateinit var stroge:FirebaseStorage
    private lateinit var binding:FragmentStartMessageBinding
    private lateinit var action:NavDirections


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentStartMessageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.toolbar_desing(R.drawable.arrow_back,Color.parseColor("#604CE3"),"Kampus",Color.parseColor("#FFFFFF"),Color.parseColor("#604CE3"),View.SYSTEM_UI_FLAG_LAYOUT_STABLE,requireActivity(),View.VISIBLE,View.VISIBLE)
        stroge=Firebase.storage
        dbUser=FirebaseFirestore.getInstance()

        binding.goBtn.setOnClickListener {
            binding.progresBar2.visibility=View.VISIBLE
            imagePost(it)
        }



    }




    //profil fotoğrafı kayıt
    fun imagePost(view: View){
        val reference=stroge.reference
        val imageReference=reference.child("profile").child("${App.user.mail}.jpg")
        imageReference.putFile(App.user.uri!!).addOnSuccessListener {

            imageReference.downloadUrl.addOnSuccessListener {
                App.user.downloadUrl=it.toString()
                dbSave(view)
            }

        }.addOnFailureListener {
            Toast.makeText(requireActivity(),"hata var",Toast.LENGTH_LONG).show()
        }

    }

    //tüm verileri database kayıt etme
    fun dbSave(view: View){

        var postMap= hashMapOf<String,Any>()
        postMap.put("mail",App.user.mail!!)
        postMap.put("user name",App.user.userName!!)
        postMap.put("description",App.user.description!!)
        postMap.put("gender",App.user.gender!!)
        postMap.put("profilUrl",App.user.downloadUrl!!)
        postMap.put("date",App.user.dataPicker!!)

        dbUser.collection("User").document("${App.user.mail}").set(postMap).addOnSuccessListener {
            Toast.makeText(requireActivity(),"Kayıt başarılı",Toast.LENGTH_LONG).show()
            binding.progresBar2.visibility=View.GONE

            action=StartMessageDirections.actionStartMessageToChat()
            Navigation.findNavController(view).navigate(action)

        }.addOnFailureListener {

        }




    }


}