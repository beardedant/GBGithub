package com.gbhomework.gbgithub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gbhomework.gbgithub.LoginClickListener
import com.gbhomework.gbgithub.LoginListAdapter
import com.gbhomework.gbgithub.R
import com.gbhomework.gbgithub.data.MockUserDataImpl
import com.gbhomework.gbgithub.databinding.FrafmentLoginListBinding

class LoginListFragment : Fragment(), LoginClickListener {
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

//TODO реализовать доступ через .App
        val moc = MockUserDataImpl()
        val user = moc.getDataForUser(context)

        val layoutManager = LinearLayoutManager(context)
        val loginListAdapter = LoginListAdapter(user, this)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = loginListAdapter

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoginClick(view: View, position: Int) {
        Toast.makeText(context, "$position", Toast.LENGTH_SHORT).show()
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, RepositoriesListFragment.newInstance())
            .addToBackStack("")
            .commit()
    }
}