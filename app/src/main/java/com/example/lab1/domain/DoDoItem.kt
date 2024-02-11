package com.example.lab1.domain

import com.example.lab1.domain.enums.PizzaDough
import com.example.lab1.domain.enums.PizzaSize

sealed class DoDoItem{

    class Combo(
        val id:Int,
        val name:String,
        val description:String,
        val imgSource:Int,
        val price:Int): DoDoItem()

    class Pizza(
        val id:Int,
        val name:String,
        val description:String,
        val imgSource:Int,
        val size: PizzaSize,
        val dough: PizzaDough,
        val price:Int): DoDoItem()
}