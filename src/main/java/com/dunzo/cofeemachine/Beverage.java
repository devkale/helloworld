package com.dunzo.cofeemachine;

import java.util.List;

public class Beverage {
    private List<Ingredient> ingredients;
    private String name;

    public Beverage(String name, List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }
}
