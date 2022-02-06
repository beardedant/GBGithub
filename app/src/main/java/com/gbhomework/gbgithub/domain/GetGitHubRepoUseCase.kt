package com.gbhomework.gbgithub.domain

import android.content.Context

interface GetGitHubRepoUseCase {
    fun getRepoForUser(context: Context?): List<GitHubRepoData>
}