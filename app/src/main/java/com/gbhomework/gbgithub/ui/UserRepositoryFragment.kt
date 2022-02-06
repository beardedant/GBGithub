package com.gbhomework.gbgithub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gbhomework.gbgithub.RepositoriesListAdapter
import com.gbhomework.gbgithub.app
import com.gbhomework.gbgithub.databinding.FragmentUserRepositoriesBinding
import com.gbhomework.gbgithub.domain.GetGitHubRepoUseCase

class UserRepositoryFragment : Fragment() {

    private val repository: GetGitHubRepoUseCase by lazy { requireActivity().app.gitHubRepoUseCase }

    companion object {
        fun newInstance() = UserRepositoryFragment()
    }

    private var _binding: FragmentUserRepositoriesBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserRepositoriesBinding.inflate(layoutInflater)

        //TODO передать сюда данные пользователя

        val recyclerView = binding.repositoryRecyclerView
        recyclerView.setHasFixedSize(true)

        Thread {
            val repoList = repository.getRepoForUser(context)
            requireActivity().runOnUiThread {
                val layoutManager = LinearLayoutManager(context)
                val loginListAdapter = RepositoriesListAdapter(repoList)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = loginListAdapter
            }
        }.start()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}