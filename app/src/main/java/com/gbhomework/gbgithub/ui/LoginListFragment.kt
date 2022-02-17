package com.gbhomework.gbgithub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gbhomework.gbgithub.LoginClickListener
import com.gbhomework.gbgithub.LoginListAdapter
import com.gbhomework.gbgithub.R
import com.gbhomework.gbgithub.app
import com.gbhomework.gbgithub.databinding.FrafmentLoginListBinding
import com.gbhomework.gbgithub.domain.GetUsersData
import com.gbhomework.gbgithub.domain.UserData

class LoginListFragment : Fragment(), LoginClickListener {

    private val repo: GetUsersData by lazy { requireActivity().app.mockUserData }

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
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, UserRepositoryFragment.newInstance(user))
            .addToBackStack("")
            .commit()
    }
}