package com.hrdijital.kampuschat.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.Item1Binding
import com.hrdijital.kampuschat.databinding.MessageItemBinding
import com.hrdijital.kampuschat.model.Message
import com.hrdijital.kampuschat.model.User


class MessageAdapter(val usertryList: ArrayList<User>): RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {


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
        return 12
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        if (position%2==1){
            holder.view.mesage=Message(" Sabah sabah iş  çıkartılar Sabah sabah iş  çıkartılar Sabah sabah iş  çıkartılar","turan","bino")
        }
        else{

            holder.view.mesage=Message("Sabah sabah iş  çıkartılar Sabah sabah iş  Sabah sabah iş  çıkartılar Sabah sabah iş  Sabah sabah iş  çıkartılar Sabah sabah iş  Sabah sabah iş  çıkartılar Sabah sabah iş ","bino","bino")
        }



        fun updateCountryList(newCountryList: List<User>) {
            usertryList.clear()
            usertryList.addAll(newCountryList)
            notifyDataSetChanged()
        }

    }


}
