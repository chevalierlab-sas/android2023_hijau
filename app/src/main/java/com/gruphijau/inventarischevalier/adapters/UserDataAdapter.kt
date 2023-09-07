package com.gruphijau.inventarischevalier.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gruphijau.inventarischevalier.activities.EditUserData
import com.gruphijau.inventarischevalier.data.UserData
import com.gruphijau.inventarischevalier.databinding.RvUserDataBinding

class UserDataAdapter(private val dataList:ArrayList<UserData>, private val activity: Activity)
    : RecyclerView.Adapter<UserDataAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvUserDataBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position: Int = adapterPosition
                val userImage = dataList[position].image
                val userName = dataList[position].name
                val userEmail = dataList[position].email
                val userPhoneNumber = dataList[position].phoneNum
                val userAddress = dataList[position].address
                val userStatus = dataList[position].status

                val intent = Intent(itemView.context, EditUserData::class.java)
                intent.putExtra("name", userName)
                intent.putExtra("email", userEmail)
                intent.putExtra("phone_num", userPhoneNumber)
                intent.putExtra("address", userAddress)
                intent.putExtra("status", userStatus)
                itemView.context.startActivity(intent)
                activity.finish()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvUserDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        val addressParts = item.address.split(",")
        val addressToShow = addressParts.firstOrNull()
        holder.binding.userImage.setImageResource(item.image)
        holder.binding.userName.text = item.name
        holder.binding.userStatus.text = "${item.status}, " + addressToShow
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}