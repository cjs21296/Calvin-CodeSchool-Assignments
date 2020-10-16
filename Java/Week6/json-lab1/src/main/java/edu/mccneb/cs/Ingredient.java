package edu.mccneb.cs;

public class Ingredient {
    private static int serialNumber = 0;
    private int id;
    private final String name;

    public Ingredient(String name) {
        this.name = name;
        this.id = serialNumber++;
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
}
