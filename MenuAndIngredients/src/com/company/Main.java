package com.company;

import MenuAndIngredients.Dish;
import MenuAndIngredients.Ingredient;
import MenuAndIngredients.Menu;
import MenuAndIngredients.Units;

public class Main {

    public static void main(String[] args) {
        Dish makkaroni=new Dish("makaroni",100);
        Ingredient meat=new Ingredient("cow meat", Units.GRAM,100,Units.KILOGRAM,false);
        makkaroni.addIngredient(meat,100);
        Menu menu=new Menu();
        menu.addDish(makkaroni);
        System.out.println(menu);

    }
}
