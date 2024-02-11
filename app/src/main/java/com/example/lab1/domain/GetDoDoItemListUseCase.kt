package com.example.lab1.domain

class GetDoDoItemListUseCase(private val repository: Repository) {
    fun getDoDoItemList(): List<DoDoItem> {
        return repository.getDoDoItemList()
    }
}