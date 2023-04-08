package com.hrdijital.kampuschat.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hrdijital.kampuschat.R
import com.hrdijital.kampuschat.databinding.MessageItemUserBinding
import com.hrdijital.kampuschat.model.User

class UserAdapterActive(val usertryList: ArrayList<User>): RecyclerView.Adapter<UserAdapterActive.UserViewHolder>(),AdapterClickListener {


    class UserViewHolder(var view: MessageItemUserBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country,parent,false)
        val view = DataBindingUtil.inflate<MessageItemUserBinding>(
            inflater,
            R.layout.message_item_user,
            parent,
            false
        )
        return UserViewHolder(view)

    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.view.user = User("","","","","","",null,"",)



        fun updateCountryList(newCountryList: List<User>) {
            usertryList.clear()
            usertryList.addAll(newCountryList)
            notifyDataSetChanged()
        }

    }

    override fun onAdapterClicked(v: View) {
        Log.d("deneme", "dsvsvsvdvs");


    }


}