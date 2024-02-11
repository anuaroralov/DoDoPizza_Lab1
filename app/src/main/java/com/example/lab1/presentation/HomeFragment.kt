package com.example.lab1.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.lab1.databinding.FragmentHomeBinding
import com.example.lab1.presentation.adapter.MainListAdapter

class HomeFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private var _binding: FragmentHomeBinding? = null

    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding is null")

    private lateinit var listAdapter:MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter= MainListAdapter()

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(activity)
            adapter=listAdapter

        }

        viewModel.dodoItems.observe(viewLifecycleOwner){
            listAdapter.submitList(it)
        }
    }
}