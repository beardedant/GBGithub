package com.gbhomework.gbgithub.data.retrofit

import com.gbhomework.gbgithub.data.retrofit.GitHubApi
import com.gbhomework.gbgithub.domain.GetGitHubRepoUseCase
import com.gbhomework.gbgithub.domain.GitHubRepoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
        api.listRepos(userName).execute().body() ?: emptyList<GitHubRepoData>()

    override fun getRepoForUserAsync(
        userName: String,
        onSuccess: (List<GitHubRepoData>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        api.listRepos(userName).enqueue(object : Callback<List<GitHubRepoData>> {
            override fun onResponse(
                call: Call<List<GitHubRepoData>>,
                response: Response<List<GitHubRepoData>>
            ) {
                onSuccess(response.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<GitHubRepoData>>, t: Throwable) {
                onError(t)
            }
        })
    }
}