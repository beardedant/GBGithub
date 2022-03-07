package com.gbhomework.gbgithub

import android.view.View
import com.gbhomework.gbgithub.domain.UserData

interface LoginClickListener {
    fun onLoginClick(view: View, position: Int, user: UserData)
}