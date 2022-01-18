package com.prodan.kmm_playground.android

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.prodan.kmm_playground.data.User

class AdapterMain(val items : List<User>) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = items[position]
        holder.firstName.text = user.name.first
        holder.lastName.text = user.name.last
        holder.avatar.load(user.picture.medium){
            transformations(CircleCropTransformation())
        }
    }

    override fun getItemCount(): Int  = items.size
}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val firstName: TextView;
    val lastName: TextView;
    val avatar: ImageView;

    init {
        // Define click listener for the ViewHolder's View.
        firstName = itemView.findViewById(R.id.firstName)
        lastName = itemView.findViewById(R.id.lastName)
        avatar = itemView.findViewById(R.id.avatar)
    }
}