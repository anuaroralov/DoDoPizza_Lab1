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

    init{
        _dodoItems.value=getDoDoItemListUseCase.getDoDoItemList()
    }
}