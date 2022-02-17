package com.gbhomework.gbgithub.data.retrofit

import com.gbhomework.gbgithub.domain.GitHubRepoData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") userName: String): Call<List<GitHubRepoData>>
}