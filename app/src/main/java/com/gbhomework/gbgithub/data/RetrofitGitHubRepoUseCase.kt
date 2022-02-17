package com.gbhomework.gbgithub.data

import com.gbhomework.gbgithub.data.retrofit.GitHubApi
import com.gbhomework.gbgithub.domain.GetGitHubRepoUseCase
import com.gbhomework.gbgithub.domain.GitHubRepoData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.github.com/"

class RetrofitGitHubRepoUseCase : GetGitHubRepoUseCase {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun getRepoForUser(userName: String): List<GitHubRepoData> =
        api.listRepos(userName).execute().body() ?: emptyList()
}