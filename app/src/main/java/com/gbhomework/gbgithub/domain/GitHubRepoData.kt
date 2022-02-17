package com.gbhomework.gbgithub.domain

import com.google.gson.annotations.SerializedName

data class GitHubRepoData(
    @SerializedName("id")
    val id: Long,
    @SerializedName("language")
    val language: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("updated_at")
    val updatedAt: String
) {
}