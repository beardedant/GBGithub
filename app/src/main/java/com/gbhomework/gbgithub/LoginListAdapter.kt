package com.gbhomework.gbgithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//TODO сделать класс с данными о пользователе и пеоедавать его в конструктор
//TODO навесить обработчик нажатий
class LoginListAdapter(
    private val userLoginName: Array<String>,
    private val userMail: Array<String>
) : RecyclerView.Adapter<LoginListAdapter.LoginListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_login_card, parent, false)
        return LoginListViewHolder(view)
    }

    override fun onBindViewHolder(holder: LoginListViewHolder, position: Int) {
        holder.login.text = userLoginName[position]
        holder.mail.text = userMail[position]
    }

    override fun getItemCount(): Int {
        return userLoginName.size
    }

    inner class LoginListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val login = itemView.findViewById<TextView>(R.id.tv_login_name)
        val mail = itemView.findViewById<TextView>(R.id.tv_login_mail)
        val avatar = itemView.findViewById<ImageView>(R.id.iv_avatar_image)
    }
}