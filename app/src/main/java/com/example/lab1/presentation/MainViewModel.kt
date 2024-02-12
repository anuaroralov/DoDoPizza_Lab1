package com.example.lab1.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab1.data.RepositoryImpl
import com.example.lab1.domain.DoDoItem
import com.example.lab1.domain.GetDoDoItemListUseCase


class MainViewModel(): ViewModel() {

    private val getDoDoItemListUseCase=GetDoDoItemListUseCase(RepositoryImpl())

    private val _dodoItems = MutableLiveData<List<DoDoItem>>()
    val dodoItems: LiveData<List<DoDoItem>>
        get()=_dodoItems

    private val _price = MutableLiveData<Int>()
    val price: LiveData<Int>
        get()=_price

    init{
        _dodoItems.value=getDoDoItemListUseCase.getDoDoItemList()
    }

    fun changeList(query:String){
            val filteredList = getDoDoItemListUseCase.getDoDoItemList().filter {
                (it is DoDoItem.Pizza && it.name.lowercase().contains(query.lowercase())) ||
                        (it is DoDoItem.Combo && it.name.lowercase().contains(query.lowercase()))
            }
            _dodoItems.value=filteredList
    }
    fun changePrice(newPrice:Int){
        _price.value=newPrice
    }
}