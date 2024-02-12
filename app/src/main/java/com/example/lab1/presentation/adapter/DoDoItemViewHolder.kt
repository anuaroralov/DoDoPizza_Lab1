package com.example.lab1.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.lab1.databinding.ItemComboBinding
import com.example.lab1.databinding.ItemPizzaBinding
import com.example.lab1.domain.DoDoItem

sealed class DoDoItemViewHolder(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {

    class PizzaViewHolder(private val binding: ItemPizzaBinding, private val onCoinClickListener: (DoDoItem)->Unit): DoDoItemViewHolder(binding){
        fun bind(pizza: DoDoItem.Pizza){
            binding.tvName.text=pizza.name
            binding.tvDescription.text=pizza.description
            binding.tvPrice.text=pizza.price.toString()+" KZT"
            binding.ivImg.setImageResource(pizza.imgSource)
            binding.root.setOnClickListener{
                onCoinClickListener(pizza)
            }
        }
    }

    class ComboViewHolder(private val binding: ItemComboBinding, private val onCoinClickListener: (DoDoItem)->Unit): DoDoItemViewHolder(binding){
        fun bind(combo: DoDoItem.Combo){
            binding.tvName.text=combo.name
            binding.tvDescription.text=combo.description
            binding.tvPrice.text=combo.price.toString()+" KZT"
            binding.ivImg.setImageResource(combo.imgSource)
            binding.root.setOnClickListener{
                onCoinClickListener(combo)
            }
        }
    }
}