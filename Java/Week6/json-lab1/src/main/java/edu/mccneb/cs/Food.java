package edu.mccneb.cs;

import java.util.ArrayList;
import java.util.List;

public class Food {
    private static int serialNumber = 0;
    private int id;
    private final String name;
    private List<Ingredient> ingredients;

    public Food(String name) {
        this.name = name;
        this.id = serialNumber++;
        ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient... ingredients) {
        for (Ingredient ingredient: ingredients) {
            this.ingredients.add(ingredient);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

}
