package com.dunzo.cofeemachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    public static void main(String[] args)  {

        Store store = new Store();
        store.fill(new Ingredient("hot_water", 500));
        store.fill(new Ingredient("hot_milk", 500));
        store.fill(new Ingredient("ginger_syrup", 100));
        store.fill(new Ingredient("sugar_syrup", 100));
        store.fill(new Ingredient("tea_leaves_syrup", 100));
        Machine machine = new Machine(3, store);
        Beverage hotTea = new Beverage(
            "hot_tea",
            new ArrayList<Ingredient>(
                Arrays.asList(
                    new Ingredient("hot_water", 200),
                    new Ingredient("hot_milk", 100),
                    new Ingredient("ginger_syrup", 10),
                    new Ingredient("sugar_syrup", 10),
                    new Ingredient("tea_leaves_syrup", 30)
                )
            )
        );
        Beverage hot_coffee = new Beverage(
                "hot_coffee",
                new ArrayList<Ingredient>(
                        Arrays.asList(
                                new Ingredient("hot_water", 100),
                                new Ingredient("ginger_syrup", 30),
                                new Ingredient("hot_milk", 400),
                                new Ingredient("sugar_syrup", 50),
                                new Ingredient("tea_leaves_syrup", 30)
                        )
                )
        );
        Beverage black_tea = new Beverage(
                "black_tea",
                new ArrayList<Ingredient>(
                        Arrays.asList(
                                new Ingredient("hot_water", 300),
                                new Ingredient("ginger_syrup", 30),
                                new Ingredient("sugar_syrup", 50),
                                new Ingredient("tea_leaves_syrup", 30)
                        )
                )
        );
        Beverage green_tea = new Beverage(
                "green_tea",
                new ArrayList<Ingredient>(
                        Arrays.asList(
                                new Ingredient("hot_water", 100),
                                new Ingredient("ginger_syrup", 30),
                                new Ingredient("sugar_syrup", 50),
                                new Ingredient("green_mixture", 30)
                        )
                )
        );

        machine.getBeverage(1, hotTea);
        machine.getBeverage(2, hot_coffee);
        machine.getBeverage(3, black_tea);
        machine.getBeverage(1, green_tea);
    }
}
