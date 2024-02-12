package com.example.lab1.domain

import com.example.lab1.domain.enums.PizzaDough
import com.example.lab1.domain.enums.PizzaSize
import java.io.Serializable

sealed class DoDoItem():Serializable{

    class Combo(
        val id:Int,
        val name:String,
        val description:String,
        val imgSource:Int,
        val price:Int): Serializable,DoDoItem()

    class Pizza(
        val id:Int,
        val name:String,
        val description:String,
        val imgSource:Int,
        val size: PizzaSize=PizzaSize.LITTLE,
        val dough: PizzaDough=PizzaDough.TRADITIONAL,
        val price:Int): Serializable,DoDoItem()
}