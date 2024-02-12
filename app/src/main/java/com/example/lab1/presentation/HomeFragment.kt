package com.example.lab1.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab1.databinding.FragmentHomeBinding
import com.example.lab1.domain.DoDoItem
import com.example.lab1.presentation.adapter.MainListAdapter


class HomeFragment : Fragment(){

    private val viewModel by viewModels<MainViewModel>()

    private var _binding: FragmentHomeBinding? = null

    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding is null")

    private lateinit var listAdapter:MainListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter= MainListAdapter{launchDetailFragment(it)}

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(activity)
            adapter=listAdapter

        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.changeList(newText)
                return true
            }
        })

        viewModel.dodoItems.observe(viewLifecycleOwner){
            if(it.isEmpty()){
                binding.imageView.visibility=(View.VISIBLE)
            }
            else{
                binding.imageView.visibility=(View.GONE)
            }
            listAdapter.submitList(it)
        }
    }

    private fun launchDetailFragment(item:DoDoItem) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(item))
    }
}
