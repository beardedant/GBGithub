package com.gbhomework.gbgithub.data

import com.gbhomework.gbgithub.domain.GetGitHubRepoUseCase
import com.gbhomework.gbgithub.domain.GitHubRepoData

class MockGitHubRepoUseCaseImpl : GetGitHubRepoUseCase {
    override fun getRepoForUser(userAlias: String): List<GitHubRepoData> {
        TODO("Not yet implemented")
    }
}