package com.hrdijital.kampuschat.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrdijital.kampuschat.adapter.UserAdapter
import com.hrdijital.kampuschat.adapter.UserAdapterActive
import com.hrdijital.kampuschat.databinding.FragmentUserListBinding
import com.hrdijital.kampuschat.utils.App


class UserList : Fragment() {

    private  var messageAdapter:UserAdapter= UserAdapter(arrayListOf())
    private  var activeUser:UserAdapterActive= UserAdapterActive(arrayListOf())
    private lateinit var binding:FragmentUserListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentUserListBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.toolbarText.text="Mesajlar"
        binding.recyler.layoutManager= LinearLayoutManager(context)
        binding.recyler.adapter=messageAdapter

        binding.recyclerActiveUser.layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerActiveUser.adapter=activeUser






    }
}