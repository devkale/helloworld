package com.dunzo.cofeemachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private Map<String,Integer> ingredients;
    // TODO make it singleton
    public Store() {
        ingredients = new HashMap<String, Integer>();
    }

    public void fill(Ingredient ingredient) {
        synchronized(this) {
            if(ingredients.containsKey(ingredient.getName())) {
                int newQuantity = ingredients.get(ingredient.getName())+ingredient.getQuantity();
                ingredients.put(ingredient.getName(), newQuantity);
            }
            else {
                ingredients.put(ingredient.getName(), ingredient.getQuantity());
            }
        }
    }

    public boolean getIngredients(List<Ingredient> ingredients) {
        synchronized(this) {
            boolean fulFilled = true;
            for (Ingredient ingredient:ingredients) {
                Integer availableQuantity = this.ingredients.get(ingredient.getName());
                if(availableQuantity==null || availableQuantity<ingredient.getQuantity()) {
                    fulFilled = false;
                    break;
                }
                this.ingredients.put(ingredient.getName(),availableQuantity-ingredient.getQuantity());
            }

            return  fulFilled;
        }
    }
}
