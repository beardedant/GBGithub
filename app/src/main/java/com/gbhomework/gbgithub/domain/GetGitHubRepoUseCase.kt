package com.gbhomework.gbgithub.domain

interface GetGitHubRepoUseCase {
    fun getRepoForUser(userName:String): List<GitHubRepoData>
}