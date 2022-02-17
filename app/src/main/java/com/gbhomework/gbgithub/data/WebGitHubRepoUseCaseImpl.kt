package com.gbhomework.gbgithub.data

import com.gbhomework.gbgithub.domain.GetGitHubRepoUseCase
import com.gbhomework.gbgithub.domain.GitHubRepoData
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WebGitHubRepoUseCaseImpl : GetGitHubRepoUseCase {
    override fun getRepoForUser(userName: String): List<GitHubRepoData> {

        val githubUrl = "https://api.github.com/users/$userName/repos"
        val gson by lazy { Gson() }
        val result = mutableListOf<GitHubRepoData>()

        val url = URL(githubUrl)
        val urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "GET"
        urlConnection.connectTimeout = 1_000

        val bufReader = BufferedReader(InputStreamReader(urlConnection.inputStream))
        val resultLine = bufReader.readLines().toString()

        val jsonResult = gson.fromJson(resultLine, Array<Array<GitHubRepoData>>::class.java)

        jsonResult.forEach {
            it.forEach { data ->
                result.add(data)
            }
        }

        urlConnection.disconnect()

        return result
    }
}