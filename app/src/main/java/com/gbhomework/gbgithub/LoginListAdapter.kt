package com.gbhomework.gbgithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gbhomework.gbgithub.domain.UserData

//TODO навесить обработчик нажатий

class LoginListAdapter(
    private val user: List<UserData>
) : RecyclerView.Adapter<LoginListAdapter.LoginListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_login_card, parent, false)
        return LoginListViewHolder(view)
    }

    override fun onBindViewHolder(holder: LoginListViewHolder, position: Int) {
        holder.login.text = user[position].userName
        holder.mail.text = user[position].userMail
        holder.avatar.setImageResource(user[position].userAvatar)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    inner class LoginListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val login: TextView = itemView.findViewById(R.id.tv_login_name)
        val mail: TextView = itemView.findViewById(R.id.tv_login_mail)
        val avatar: ImageView = itemView.findViewById(R.id.iv_avatar_image)
    }
}