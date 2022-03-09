package com.gbhomework.gbgithub.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gbhomework.gbgithub.data.MockGitHubRepoUseCaseImpl
import com.gbhomework.gbgithub.domain.GitHubRepoData
import com.gbhomework.gbgithub.domain.UserData


class UserRepoListViewModel() :
    ViewModel() {

    //    private val retrofitGitHubRepoUseCase : RetrofitGitHubRepoUseCase = RetrofitGitHubRepoUseCase()
    // todo как во вью модель передать репозиторий из App?

    private val retrofitGitHubRepoUseCase : MockGitHubRepoUseCaseImpl = MockGitHubRepoUseCaseImpl()
    private val repoLiveData: MutableLiveData<List<GitHubRepoData>> = MutableLiveData()
    private val userLiveData: MutableLiveData<UserData> = MutableLiveData()
    private val repoErrorLiveData: MutableLiveData<String> = MutableLiveData()

    fun setUserData(user: UserData) {
        userLiveData.postValue(user)

        retrofitGitHubRepoUseCase.getRepoForUserAsync(
            user.userAlias,
            onSuccess = {
                repoLiveData.postValue(it)
            },
            onError = {
                repoErrorLiveData.postValue(it.message)
            })
    }

    fun getRepoListLiveData(): LiveData<List<GitHubRepoData>> = repoLiveData
    fun getUserLiveData(): LiveData<UserData> = userLiveData
    fun getErrorLiveData(): LiveData<String> = repoErrorLiveData
}

