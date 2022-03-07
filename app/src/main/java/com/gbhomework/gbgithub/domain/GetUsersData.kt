package com.gbhomework.gbgithub.domain

import android.content.Context

interface GetUsersData {
    fun getDataForUser(context: Context?): List<UserData>
}