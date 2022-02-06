package com.gbhomework.gbgithub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gbhomework.gbgithub.LoginListAdapter
import com.gbhomework.gbgithub.data.MockUserDataImpl
import com.gbhomework.gbgithub.databinding.FrafmentLoginListBinding

class LoginListFragment : Fragment() {
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
        val loginListAdapter = LoginListAdapter(user)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = loginListAdapter

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}