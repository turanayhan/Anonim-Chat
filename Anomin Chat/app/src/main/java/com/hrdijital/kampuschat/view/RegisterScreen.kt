package com.hrdijital.kampuschat.view

import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.FragmentRegisterScreenBinding
import com.hrdijital.kampuschat.model.User
import com.hrdijital.kampuschat.utils.App


class RegisterScreen : Fragment() {


    private lateinit var register: FirebaseAuth
    private lateinit var bind: FragmentRegisterScreenBinding
    private lateinit var db:FirebaseFirestore
    private lateinit var action:NavDirections
    private  lateinit var registerMail:String
    private  lateinit var registerUser:String
    private  lateinit var registerPassword:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        register=FirebaseAuth.getInstance()
        db=FirebaseFirestore.getInstance()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= FragmentRegisterScreenBinding.inflate(inflater,container,false)

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.toolbar_desing(R.drawable.arrow_back,Color.parseColor("#604CE3"),"Kampus",Color.parseColor("#FFFFFF"),Color.parseColor("#604CE3"),View.SYSTEM_UI_FLAG_LAYOUT_STABLE,requireActivity(),View.VISIBLE,View.VISIBLE)
        bind.register.setOnClickListener(View.OnClickListener {
            register(it)
        })
    }



    fun register(_context: View){

        registerMail=bind.registerMail.text.toString()
        registerPassword=bind.registerPassword.text.toString()

       bind.registerMail.addTextChangedListener {


      //  bind.register.background=(resources.getDrawable(R.drawable.arrow_back))

       }

        if (registerMail.trim().equals("")||registerPassword.trim().equals(""))
        {
            Toast.makeText(requireActivity(), "Lütfen eksik yerleri doldurunuz", Toast.LENGTH_SHORT).show()
        }
        else{
            bind.progresBar.visibility=View.VISIBLE
            register.createUserWithEmailAndPassword(registerMail, registerPassword).addOnCompleteListener(
                OnCompleteListener {

                    if(it.isSuccessful){

                        Toast.makeText(activity,"giris Başarılı",Toast.LENGTH_LONG).show()

                        bind.progresBar.visibility=View.GONE

                        dbSave(registerMail,registerUser,registerPassword,_context)

                    }



                }).addOnFailureListener(OnFailureListener {
                Toast.makeText(activity,"Bu kullanıcı zaten kayıtlı",Toast.LENGTH_LONG).show()

            })
        }
    }


    fun dbSave(mail:String,registerUser:String,password:String,_context:View){

   /*     db.collection("User")
            .add(User(mail,registerUser,password))
            .addOnSuccessListener {
                action=RegisterScreenDirections.actionRegisterScreenToLoginScreen()
                Navigation.findNavController(_context).navigate(action)

            }*/
    }




}


