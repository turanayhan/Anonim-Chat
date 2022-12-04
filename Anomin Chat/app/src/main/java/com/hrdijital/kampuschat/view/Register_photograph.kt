package com.hrdijital.kampuschat.view

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.hrdijital.kampuschat.R

import com.hrdijital.kampuschat.databinding.FragmentRegisterPhotographBinding
import com.hrdijital.kampuschat.utils.App


class Register_photograph : Fragment() {

    private lateinit var photoBinding: FragmentRegisterPhotographBinding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var action: NavDirections



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        photoBinding = FragmentRegisterPhotographBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return photoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.toolbar_desing(
            R.drawable.arrow_back,
            Color.parseColor("#604CE3"),"Kampus",
            Color.parseColor("#FFFFFF"),
            Color.parseColor("#604CE3"),View.SYSTEM_UI_FLAG_LAYOUT_STABLE,requireActivity(),View.VISIBLE,View.VISIBLE)

        register()
        registerLauncher()



    }

    //galeri erişim görsel seçme
    fun selectImage(view: View) {
        if(ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Snackbar.make(view, "Galeri erişim izni yok", Snackbar.LENGTH_INDEFINITE).setAction("izin ver",
                    View.OnClickListener {
                        permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                    }).show()
            } else {
               permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        } else {
            val intentToGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            activityResultLauncher.launch(intentToGallery)
        }
    }

//galeri erişim
    private fun registerLauncher() {
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val intentFromResult = result.data
                    if (intentFromResult != null) {
                        val imageData = intentFromResult.data
                        App.user.uri=imageData
                        photoBinding.imageView.setImageURI(App.user.uri)
                        photoBinding.imgBg.visibility=View.GONE
                    }
                }
            }

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            if (result) {
                //permission granted
                val intentToGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)
            } else {
                //permission denied
                Toast.makeText(requireActivity(), "Galeri erişim izni yok", Toast.LENGTH_LONG).show()
            }
        }



    }
//buton kontrolleri
    fun register(){
        photoBinding.imageView.setOnClickListener {
            selectImage(it)
        }

        photoBinding.registerPhoto.setOnClickListener {

            if (App.user.uri==null){
               Snackbar.make(it, "Lütfen profil Fotğrafı ekleyiniz..", Snackbar.LENGTH_LONG).show()
            }

            else{
                action=Register_photographDirections.actionRegisterPhotographToStartMessage()
                Navigation.findNavController(it).navigate(action)

            }



        }

    }

}

