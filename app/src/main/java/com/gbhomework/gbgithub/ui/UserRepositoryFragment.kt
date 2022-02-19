package com.gbhomework.gbgithub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gbhomework.gbgithub.RepositoriesListAdapter
import com.gbhomework.gbgithub.app
import com.gbhomework.gbgithub.databinding.FragmentUserRepositoriesBinding
import com.gbhomework.gbgithub.domain.GetGitHubRepoUseCase
import com.gbhomework.gbgithub.domain.GitHubRepoData
import com.gbhomework.gbgithub.domain.UserData
import com.gbhomework.gbgithub.viewmodel.RepoListViewModel

class UserRepositoryFragment() : Fragment() {

    private lateinit var repoListViewModel: RepoListViewModel

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
        repoListViewModel = ViewModelProvider(requireActivity()).get(RepoListViewModel::class.java)

        repoListViewModel.getUserLiveData().observe(viewLifecycleOwner) {
            initUserCase(it)
        }

        repoListViewModel.getRepoListLiveData().observe(viewLifecycleOwner) {
            initRecyclerView(it)
        }

        repoListViewModel.getErrorLiveData().observe(viewLifecycleOwner) {
            val error: String = it
        }

        return binding.root
    }

    private fun initRecyclerView(it: List<GitHubRepoData>) {
        val recyclerView = binding.repositoryRecyclerView
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        val loginListAdapter = RepositoriesListAdapter(it)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = loginListAdapter
    }

    private fun initUserCase(user: UserData) {
        binding.include.tvLoginName.text = user.userName
        binding.include.tvLoginMail.text = user.userMail
        binding.include.ivAvatarImage.setImageResource(user.userAvatar)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}