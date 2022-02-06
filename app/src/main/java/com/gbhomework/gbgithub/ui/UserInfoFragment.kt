package com.gbhomework.gbgithub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gbhomework.gbgithub.R
import com.gbhomework.gbgithub.RepositoriesListAdapter
import com.gbhomework.gbgithub.databinding.FragmentUserinfoBinding

class UserInfoFragment : Fragment() {
    companion object {
        fun newInstance() = UserInfoFragment()
    }

    private var _binding: FragmentUserinfoBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserinfoBinding.inflate(layoutInflater)

        //TODO передать сюда данные пользователя

        val recyclerView = binding.repositoryRecyclerView
        recyclerView.setHasFixedSize(true)

        val repoName: Array<String> = resources.getStringArray(R.array.repo_test)
        val repoLanguage: Array<String> = resources.getStringArray(R.array.login_mail)
        val repoLastUpdate: Array<String> = resources.getStringArray(R.array.login_mail)

        val layoutManager = LinearLayoutManager(context)
        val loginListAdapter = RepositoriesListAdapter(repoName)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = loginListAdapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}