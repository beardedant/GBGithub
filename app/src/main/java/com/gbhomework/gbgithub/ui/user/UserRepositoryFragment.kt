package com.gbhomework.gbgithub.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gbhomework.gbgithub.databinding.FragmentUserRepositoriesBinding
import com.gbhomework.gbgithub.domain.GitHubRepoData
import com.gbhomework.gbgithub.domain.UserData
import com.gbhomework.gbgithub.ui.viewmodel.UserRepoListViewModel

class UserRepositoryFragment() : Fragment() {

    private lateinit var userRepoListViewModel: UserRepoListViewModel

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
        userRepoListViewModel = ViewModelProvider(requireActivity()).get(UserRepoListViewModel()::class.java)

        userRepoListViewModel.getUserLiveData().observe(viewLifecycleOwner) {
            initUserCase(it)
        }

        userRepoListViewModel.getRepoListLiveData().observe(viewLifecycleOwner) {
            initRecyclerView(it)
        }

        userRepoListViewModel.getErrorLiveData().observe(viewLifecycleOwner) {
            val error: String = it
        }

        return binding.root
    }

    private fun initRecyclerView(it: List<GitHubRepoData>) {
        val recyclerView = binding.repositoryRecyclerView
        recyclerView.setHasFixedSize(true)

        val loginListAdapter = UserReposListAdapter(it)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
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