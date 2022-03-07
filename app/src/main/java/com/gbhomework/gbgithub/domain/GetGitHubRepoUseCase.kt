package com.gbhomework.gbgithub.domain

interface GetGitHubRepoUseCase {
    fun getRepoForUser(userName:String): List<GitHubRepoData>

    fun getRepoForUserAsync(
        userName: String,
        onSuccess: (List<GitHubRepoData>) -> Unit,
        onError: (Throwable) -> Unit
    )
}