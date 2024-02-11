package com.example.lab1.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.lab1.R
import com.example.lab1.databinding.ItemComboBinding
import com.example.lab1.databinding.ItemPizzaBinding
import com.example.lab1.domain.DoDoItem
import java.lang.Exception

class MainListAdapter():
    ListAdapter<DoDoItem, DoDoItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoDoItemViewHolder {
        return when(viewType){
            R.layout.item_combo->DoDoItemViewHolder.ComboViewHolder(
                ItemComboBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_pizza->DoDoItemViewHolder.PizzaViewHolder(
                ItemPizzaBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else->throw Exception("Invalid viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)){
            is DoDoItem.Combo-> R.layout.item_combo
            is DoDoItem.Pizza->R.layout.item_pizza
        }
    }

    override fun onBindViewHolder(viewHolder: DoDoItemViewHolder, position: Int) {
        when(viewHolder){
            is DoDoItemViewHolder.PizzaViewHolder->viewHolder.bind(getItem(position) as DoDoItem.Pizza)
            is DoDoItemViewHolder.ComboViewHolder->viewHolder.bind(getItem(position) as DoDoItem.Combo)
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<DoDoItem>() {

        override fun areItemsTheSame(oldItem: DoDoItem, newItem: DoDoItem): Boolean {
            return when {
                oldItem is DoDoItem.Combo && newItem is DoDoItem.Combo ->
                    oldItem.id == newItem.id
                oldItem is DoDoItem.Pizza && newItem is DoDoItem.Pizza ->
                    oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: DoDoItem, newItem: DoDoItem): Boolean {
            return when {
                oldItem is DoDoItem.Combo && newItem is DoDoItem.Combo ->
                    oldItem == newItem
                oldItem is DoDoItem.Pizza && newItem is DoDoItem.Pizza ->
                    oldItem == newItem
                else -> false
            }
        }
    }
}