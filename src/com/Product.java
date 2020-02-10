package com.DietHelper;

import java.util.LinkedList;
import java.util.List;

import static com.DietHelper.Variables.productsList;

public class Product {
    private String name;
    private int protein, carbohydrates, fat, calories;
    private boolean isForDiabetic, isVegan, isVegetarian, hasLactose, hasPeanuts, hasGluten;

    public Product() {
    }

    public int getProtein() {
        return protein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isForDiabetic() {
        return isForDiabetic;
    }

    public void setForDiabetic(boolean forDiabetic) {
        isForDiabetic = forDiabetic;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isHasLactose() {
        return hasLactose;
    }

    public void setHasLactose(boolean hasLactose) {
        this.hasLactose = hasLactose;
    }

    public boolean isHasPeanuts() {
        return hasPeanuts;
    }

    public void setHasPeanuts(boolean hasPeanuts) {
        this.hasPeanuts = hasPeanuts;
    }

    public boolean isHasGluten() {
        return hasGluten;
    }
    public void setHasGluten(boolean hasGluten) {
        this.hasGluten = hasGluten;
    }

    public static void listOfProducts() {
        System.out.println("Lista produktów: " + "\n Legenda: B= białko, WW = węglowodany, T = tłuszcze, Kcal = ilość kalorii w 100g, W = wegański, WT = wegetariański, L = zawiera laktozę w składzie, O = zawiera orzechy w składzie, D = bezpieczny dla diabetyków, G = zawiera gluten.");
        if(productsList.size() == 0){
            System.out.println("Brak produktów w bazie.");
        }else {
            for (int i = 0; i < productsList.size(); i++) {
                System.out.print(i+1 + ". " + productsList.get(i).getName() + " B: " + productsList.get(i).getProtein() + " WW: " + productsList.get(i).getCarbohydrates() + " T: " + productsList.get(i).getFat() + " Kcal: " +
                        productsList.get(i).getCalories());
                if (productsList.get(i).isVegan()) {
                    System.out.print(" W: Tak, ");
                }if (!productsList.get(i).isVegan()) {
                    System.out.print(" W: Nie, ");
                }if (productsList.get(i).isVegetarian()) {
                    System.out.print("WT: Tak, ");
                }if (!productsList.get(i).isVegetarian()) {
                    System.out.print("WT: Nie, ");
                }if (productsList.get(i).isHasLactose()) {
                    System.out.print("L: Tak, ");
                }if (!productsList.get(i).isHasLactose()) {
                    System.out.print("L: Nie, ");
                }if (productsList.get(i).isHasPeanuts()) {
                    System.out.print("O: Tak, ");
                }if (!productsList.get(i).isHasPeanuts()) {
                    System.out.print("O: Nie, ");
                }if (productsList.get(i).isForDiabetic()) {
                    System.out.print("D: Tak, ");
                }if (!productsList.get(i).isForDiabetic()) {
                    System.out.print("D: Nie, ");
                }if(productsList.get(i).isHasGluten()){
                    System.out.println("G: Tak.");
                }if(!productsList.get(i).isHasGluten()) {
                    System.out.println("G: Nie.");
                }
            }
        }
    }
}
