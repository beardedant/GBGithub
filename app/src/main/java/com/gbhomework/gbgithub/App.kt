package com.gbhomework.gbgithub

import android.app.Application
import android.content.Context
import com.gbhomework.gbgithub.data.MockGitHubRepoUseCaseImpl
import com.gbhomework.gbgithub.data.MockUserDataImpl
import com.gbhomework.gbgithub.domain.GetGitHubRepoUseCase
import com.gbhomework.gbgithub.domain.GetUsersData

class App : Application() {
    val mockUserData: GetUsersData by lazy { MockUserDataImpl() }
    val mockGitHubRepoUseCase: GetGitHubRepoUseCase by lazy { MockGitHubRepoUseCaseImpl() }

}

val Context.app
    get() = applicationContext as App