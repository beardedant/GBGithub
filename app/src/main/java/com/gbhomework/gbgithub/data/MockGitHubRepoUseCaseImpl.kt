package com.gbhomework.gbgithub.data

import android.content.Context
import com.gbhomework.gbgithub.R
import com.gbhomework.gbgithub.domain.GetGitHubRepoUseCase
import com.gbhomework.gbgithub.domain.GitHubRepoData
import com.gbhomework.gbgithub.ui.MainActivity

class MockGitHubRepoUseCaseImpl : GetGitHubRepoUseCase {
    override fun getRepoForUser(userName:String): List<GitHubRepoData> {
//
        val reposList = mutableListOf<GitHubRepoData>()
//
//        val repoName = context?.resources!!.getStringArray(R.array.repo_name)
//        val repoLanguage = context.resources.getStringArray(R.array.repo_language)
//        val repoLastUpdate = context.resources.getStringArray(R.array.repo_last_update)
//
//        for (i in 0..repoName.lastIndex) {
//            val repository = GitHubRepoData(0, repoLanguage[i], repoName[i], repoLastUpdate[i])
//            reposList.add(repository)
//        }
        return reposList
    }
}