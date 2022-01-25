package com.gbhomework.gbgithub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gbhomework.gbgithub.databinding.FragmentRepositoriesListBinding

class RepositoriesListFragment : Fragment() {
    companion object {
        fun newInstance() = RepositoriesListFragment()
    }

    private var _binding: FragmentRepositoriesListBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoriesListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO написать нормальный RecyclerView, реализовать получение данных по схеме MVP или MVVM
        binding.repositoryCard.apply {
            repositoryName.text = "тестовый репозиторий"
            repositoryLanguage.text = "kotlin"
            repositoryLastUpdate.text = "10 минут назад"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}