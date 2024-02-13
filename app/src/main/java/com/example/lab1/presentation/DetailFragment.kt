package com.example.lab1.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.lab1.R
import com.example.lab1.databinding.FragmentDetailBinding
import com.example.lab1.domain.DoDoItem
import com.example.lab1.domain.enums.PizzaDough
import com.example.lab1.domain.enums.PizzaSize

class DetailFragment : Fragment() {

    private val args by navArgs<DetailFragmentArgs>()

    private val viewModel by viewModels<MainViewModel>()

    private var _binding: FragmentDetailBinding? = null

    private val binding: FragmentDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(args.doDoItem is DoDoItem.Combo){
            with(binding){
                radioGroup1.visibility=View.GONE
                radioGroup2.visibility=View.GONE
                val item=args.doDoItem as DoDoItem.Combo
                tvName.text=item.name
                tvDescription.text=item.description
                ivImg.setImageResource(item.imgSource)
                button.text= String.format("В КОРЗИНУ ЗА %d KZT",item.price)
            }


        }
        else if(args.doDoItem is DoDoItem.Pizza){
            with(binding){
                val item=args.doDoItem as DoDoItem.Pizza
                tvName.text=item.name
                tvDescription.text=item.description
                ivImg.setImageResource(item.imgSource)
                viewModel.changePrice(item.price)
                viewModel.price.observe(viewLifecycleOwner){
                    button.text= String.format("В КОРЗИНУ ЗА %d KZT",it)
                }
                radioGroup1.setOnCheckedChangeListener { _, checkedId ->
                    when (checkedId) {
                        R.id.rb_little -> {
                            viewModel.changePrice(item.price)
                            item.size=PizzaSize.LITTLE
                        }
                        R.id.rb_medium -> {
                            viewModel.changePrice(item.price+1000)
                            item.size=PizzaSize.MEDIUM
                        }
                        R.id.rb_big -> {
                            viewModel.changePrice(item.price+2000)
                            item.size=PizzaSize.BIG
                        }
                    }
                }
                radioGroup2.setOnCheckedChangeListener { _, checkedId ->
                    when (checkedId) {
                        R.id.rb_thin -> {
                            item.dough=PizzaDough.THIN
                        }
                        R.id.rb_traditional -> {
                            item.dough=PizzaDough.TRADITIONAL
                        }
                    }
                }
            }


        }
    }

}