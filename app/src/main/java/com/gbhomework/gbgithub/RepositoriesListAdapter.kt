package com.gbhomework.gbgithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gbhomework.gbgithub.domain.GitHubRepoData

class RepositoriesListAdapter(
    private val repositories: List<GitHubRepoData>
) : RecyclerView.Adapter<RepositoriesListAdapter.RepositoriesListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesListViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_repository_card, parent, false)
        return RepositoriesListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoriesListViewHolder, position: Int) {
        holder.name.text = repositories[position].full_name
        holder.language.text = repositories[position].language
        holder.lastUpdate.text = repositories[position].updated_at
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    inner class RepositoriesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = itemView.findViewById(R.id.tv_repository_name)
        val language: TextView = itemView.findViewById(R.id.tv_repository_language)
        val lastUpdate: TextView = itemView.findViewById(R.id.tv_repository_last_update)
    }
}