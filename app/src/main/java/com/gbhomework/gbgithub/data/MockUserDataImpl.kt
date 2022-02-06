package com.gbhomework.gbgithub.data

import android.content.Context
import com.gbhomework.gbgithub.R
import com.gbhomework.gbgithub.domain.GetUsersData
import com.gbhomework.gbgithub.domain.UserData


class MockUserDataImpl : GetUsersData {

    override fun getDataForUser(context: Context?): List<UserData> {
        val userList = mutableListOf<UserData>()

        val userFullName = context?.resources!!.getStringArray(R.array.login_full_name)
        val userMail = context.resources.getStringArray(R.array.login_mail)
        val useAlias = context.resources.getStringArray(R.array.login_alias)
        val userAvatar = context.resources.obtainTypedArray(R.array.avatars)

        for (i in 0..userFullName.lastIndex) {
            val user = UserData(
                userFullName[i],
                userMail[i],
                useAlias[i],
                userAvatar.getResourceId(i, 0)
            )

            userList.add(user)
        }

        return userList
    }
}