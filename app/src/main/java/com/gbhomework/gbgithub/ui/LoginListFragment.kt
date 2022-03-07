package com.gbhomework.gbgithub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gbhomework.gbgithub.LoginClickListener
import com.gbhomework.gbgithub.LoginListAdapter
import com.gbhomework.gbgithub.R
import com.gbhomework.gbgithub.app
import com.gbhomework.gbgithub.databinding.FrafmentLoginListBinding
import com.gbhomework.gbgithub.domain.GetUsersData
import com.gbhomework.gbgithub.domain.UserData
import com.gbhomework.gbgithub.viewmodel.RepoListViewModel

class LoginListFragment : Fragment(), LoginClickListener {

    private val repo: GetUsersData by lazy { requireActivity().app.mockUserData }
    private lateinit var repoListViewModel: RepoListViewModel

    companion object {
        fun newInstance() = LoginListFragment()

    }

    private var _binding: FrafmentLoginListBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FrafmentLoginListBinding.inflate(layoutInflater)
        repoListViewModel = ViewModelProvider(requireActivity()).get(RepoListViewModel::class.java)
        val recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)

        val users = repo.getDataForUser(context)

        val layoutManager = LinearLayoutManager(context)
        val loginListAdapter = LoginListAdapter(users, this)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = loginListAdapter

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoginClick(view: View, position: Int, user: UserData) {
        repoListViewModel.setUserData(user)

        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, UserRepositoryFragment.newInstance())
            .addToBackStack("")
            .commit()
    }
}