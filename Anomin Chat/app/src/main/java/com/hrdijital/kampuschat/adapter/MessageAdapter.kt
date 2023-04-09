package com.hrdijital.kampuschat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.Item1Binding
import com.hrdijital.kampuschat.model.Message


class MessageAdapter(val msgList: ArrayList<Message>): RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {


    class MessageViewHolder(var view: Item1Binding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country,parent,false)
        val view = DataBindingUtil.inflate<Item1Binding>(
            inflater,
            R.layout.item1,
            parent,
            false
        )
        return MessageViewHolder(view)

    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        holder.view.msg =Message("dscds")





    }



}

