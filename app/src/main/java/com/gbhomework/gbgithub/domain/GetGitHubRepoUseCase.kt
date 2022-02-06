package com.gbhomework.gbgithub.domain

interface GetGitHubRepoUseCase {
    fun getRepoForUser(userAlias: String): List<GitHubRepoData>
}