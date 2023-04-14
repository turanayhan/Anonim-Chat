package com.hrdijital.kampuschat.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.adapter.MessageAdapter
import com.hrdijital.kampuschat.databinding.FragmentMessageBinding


class message : Fragment() {

    lateinit var binding:FragmentMessageBinding
    private  var messageAdapter: MessageAdapter = MessageAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMessageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerView.layoutManager= LinearLayoutManager(context)
        binding.recyclerView.adapter=messageAdapter
        



    }

}