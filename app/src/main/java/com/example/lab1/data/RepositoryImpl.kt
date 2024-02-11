package com.example.lab1.data

import com.example.lab1.R
import com.example.lab1.domain.DoDoItem
import com.example.lab1.domain.Repository
import com.example.lab1.domain.enums.PizzaDough
import com.example.lab1.domain.enums.PizzaSize

class RepositoryImpl():Repository {

    override fun getDoDoItemList(): List<DoDoItem> {
        return listOf(
            DoDoItem.Pizza(1,"Вау! Кебаб",
                "Мясо говядины, соус ранч, сыр моцарелла, сладкий перец, томаты, красный лук и фирменный томатный соус",
                R.drawable.background_price,
                PizzaSize.LITTLE,
                PizzaDough.TRADITIONAL,
                4400),
            DoDoItem.Pizza(2,"Пепперони с грибами",
                "Пикантная пепперони, моцарелла, шампиньоны, соус альфредо",
                R.drawable.background_price,
                PizzaSize.LITTLE,
                PizzaDough.TRADITIONAL,
                2000),
            DoDoItem.Pizza(3,"Наруто Пицца",
                "Куриные кусочки, соус терияки, ананасы, моцарелла, фирменный соус альфредо",
                R.drawable.background_price,
                PizzaSize.LITTLE,
                PizzaDough.TRADITIONAL,
                3900),
            DoDoItem.Combo(4,"Комбо от Смешариков",
                "Одобрено героями мультфильма: маленькая пицца любого вкуса и набор юного садовода. Цена комбо зависит от выбранных пицц и может быть увеличена",
                R.drawable.smeshariki,
                2300),
            DoDoItem.Pizza(5,"Ветчина и огурчика",
                "Соус ранч, моцарелла, ветчина из цыпленка, маринованные огурчики, красный лук",
                R.drawable.background_price,
                PizzaSize.LITTLE,
                PizzaDough.TRADITIONAL,
                2000))

    }
}