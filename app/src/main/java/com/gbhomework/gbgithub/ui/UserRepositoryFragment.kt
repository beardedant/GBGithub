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
import com.gbhomework.gbgithub.domain.UserData

class UserRepositoryFragment(val user: UserData) : Fragment() {

    private val repository: GetGitHubRepoUseCase by lazy { requireActivity().app.gitHubRepoUseCase }

    companion object {
        fun newInstance(user: UserData) = UserRepositoryFragment(user)
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

        initUserCase()

        val recyclerView = binding.repositoryRecyclerView
        recyclerView.setHasFixedSize(true)

        Thread {
            val repoList = repository.getRepoForUser(user.userAlias)
            requireActivity().runOnUiThread {
                val layoutManager = LinearLayoutManager(context)
                val loginListAdapter = RepositoriesListAdapter(repoList)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = loginListAdapter
            }
        }.start()

        return binding.root
    }

    private fun initUserCase() {
        binding.include.tvLoginName.text = user.userName
        binding.include.tvLoginMail.text = user.userMail
        binding.include.ivAvatarImage.setImageResource(user.userAvatar)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}