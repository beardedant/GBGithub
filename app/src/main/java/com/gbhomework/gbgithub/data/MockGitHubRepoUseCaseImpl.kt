package com.gbhomework.gbgithub.data

import android.content.Context
import com.gbhomework.gbgithub.R
import com.gbhomework.gbgithub.domain.GetGitHubRepoUseCase
import com.gbhomework.gbgithub.domain.GitHubRepoData
import com.gbhomework.gbgithub.ui.MainActivity

private val repoName = arrayListOf(
    "Time Machine",
    "Fur coat for wife",
    "Punch Yakin in the face",
    "Save the king"
)
private val repoLanguage = arrayListOf(
    "Kotlin", "Java", "Judo", "Kotlin"
)
private val repoLastUpdate = arrayListOf(
    "02.03.1724", "08.05.2015", "03.18.2017", "12.01.2021"
)

class MockGitHubRepoUseCaseImpl : GetGitHubRepoUseCase {
    override fun getRepoForUser(userName: String): List<GitHubRepoData> {
//
        val reposList = mutableListOf<GitHubRepoData>()

        for (i in 0..repoName.lastIndex) {
            val repository = GitHubRepoData(0, repoLanguage[i], repoName[i], repoLastUpdate[i])
            reposList.add(repository)
        }
        return reposList
    }

    override fun getRepoForUserAsync(
        userName: String,
        onSuccess: (List<GitHubRepoData>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        onSuccess (getRepoForUser(userName))
    }
}