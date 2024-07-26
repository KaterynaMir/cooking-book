package com.funcooking.model;

public class Ingredient {
    private String name;
    private double quantity;
    private Measure measure;

    public Ingredient(String name, double quantity, Measure measure) {
        this.name = name;
        this.quantity = quantity;
        this.measure = measure;
    }

    @Override
    public String toString() {
        return name + " - " + quantity + " " + measure.toString().toLowerCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public enum Measure {
        G,          // grams
        ML,         // milliliters
        PC          // pieces
    }
}
