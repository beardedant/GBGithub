package com.gbhomework.gbgithub.data

import android.content.Context
import com.gbhomework.gbgithub.R
import com.gbhomework.gbgithub.domain.GetUsersData
import com.gbhomework.gbgithub.domain.UserData

private val userFullName = arrayListOf(
    "Александр Сергеевич Тимофеев",
    "Иван Васильевич Бунша",
    "Ульяна Андреевна Бунша",
    "Антон Семёнович Шпак"
)
private val userMail = arrayListOf(
    "shurik@mail.net",
    "i.bunsha@mail.net",
    "y.bunsha@mail.net",
    "shpak@mail.net"
)
private val useAlias = arrayListOf(
    "shurik",
    "android",
    "square",
    "beardedant"
)
private val userAvatar = arrayListOf(
    R.drawable.avatar_i,
    R.drawable.avatar_i,
    R.drawable.avatar_i,
    R.drawable.avatar_i,
)

class MockUserDataImpl : GetUsersData {
    override fun getDataForUser(): List<UserData> {
        val userList = mutableListOf<UserData>()

        for (i in 0..userFullName.lastIndex) {
            val user = UserData(
                userFullName[i],
                userMail[i],
                useAlias[i],
                userAvatar[i]
            )
            userList.add(user)
        }
        return userList
    }
}