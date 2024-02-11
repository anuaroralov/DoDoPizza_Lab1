package com.example.lab1.domain

interface Repository {
    fun getDoDoItemList(): List<DoDoItem>
}