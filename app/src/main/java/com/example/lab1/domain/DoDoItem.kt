package com.example.lab1.domain

import com.example.lab1.domain.enums.PizzaDough
import com.example.lab1.domain.enums.PizzaSize
import java.io.Serializable

sealed class DoDoItem:Serializable{

    data class Combo(
        val id:Int,
        val name:String,
        val description:String,
        val imgSource:Int,
        val price:Int): Serializable,DoDoItem()

    data class Pizza(
        val id:Int,
        val name:String,
        val description:String,
        val imgSource:Int,
        var size: PizzaSize=PizzaSize.LITTLE,
        var dough: PizzaDough=PizzaDough.TRADITIONAL,
        var price:Int): Serializable,DoDoItem()
}