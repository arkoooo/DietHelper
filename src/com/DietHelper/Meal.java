package com.DietHelper;

import java.util.LinkedList;
import java.util.List;

import static com.DietHelper.Sentences.changeSizeOfMeal;
import static com.DietHelper.Sentences.changeTypeOfMeal;
import static com.DietHelper.Variables.*;

public class Meal {
    private String name;
    private int protein, carbohydrates, fat, calories;
    private boolean isForDiabetic = false, isVegan = false, isVegetarian = false, hasLactose = true, hasPeanuts = true, hasGluten = true;
    private TypeOfMeal typeOfMeal;
    private SizeOfMeal sizeOfMeal;
    public List<Product> listOfProductsInMeal = new LinkedList<>();
    public List<Integer> weightOfProducts = new LinkedList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getProtein() {
        return protein;
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
    public SizeOfMeal getSizeOfMeal() {
        return sizeOfMeal;
    }
    public void setSizeOfMeal(SizeOfMeal sizeOfMeal) {
        this.sizeOfMeal = sizeOfMeal;
    }
    public TypeOfMeal getTypeOfMeal() {
        return typeOfMeal;
    }
    public void setTypeOfMeal(TypeOfMeal typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }

    public static void listOfMeals(List<Meal> mealsList) {
        System.out.println("Lista posiłków: " + "\n Legenda: B= białko, WW = węglowodany, T = tłuszcze, Kcal = ilość kalorii w 100g, W = wegański, WT = wegetariański, L = zawiera laktozę w składzie, " +
                "O = zawiera orzechy w składzie, D = bezpieczny dla diabetków, G = zawiera gluten.");
        if (mealsList.size() == 0) {
            System.out.println("Brak posiłków w bazie.");
        } else {
            for (int i = 0; i < mealsList.size(); i++) {
                System.out.print(i + 1 + ". " + mealsList.get(i).getName() + " B: " + mealsList.get(i).getProtein() + ", WW: " + mealsList.get(i).getCarbohydrates() + ", T: " +
                        mealsList.get(i).getFat() + ", Kcal: " + mealsList.get(i).getCalories() + " Rodzaj posiłku: " + changeTypeOfMeal(mealsList.get(i).getTypeOfMeal())
                        + " Rozmiar posiłku: " + changeSizeOfMeal(mealsList.get(i).getSizeOfMeal()));
                if (mealsList.get(i).isVegan()) {
                    System.out.print(" W: Tak, "); }
                if (!mealsList.get(i).isVegan()) { System.out.print(" W: Nie, "); }
                if (mealsList.get(i).isVegetarian()) { System.out.print("WT: Tak, "); }
                if (!mealsList.get(i).isVegetarian()) { System.out.print("WT: Nie, "); }
                if (mealsList.get(i).isHasLactose()) { System.out.print("L: Tak, "); }
                if (!mealsList.get(i).isHasLactose()) { System.out.print("L: Nie, "); }
                if (mealsList.get(i).isHasPeanuts()) { System.out.print("O: Tak, "); }
                if (!mealsList.get(i).isHasPeanuts()) { System.out.print("O: Nie, "); }
                if (mealsList.get(i).isForDiabetic()) { System.out.print("D: Tak, "); }
                if (!mealsList.get(i).isForDiabetic()) { System.out.print("D: Nie, "); }
                if (mealsList.get(i).isHasGluten()) { System.out.println("G: Tak."); }
                if (!mealsList.get(i).isHasGluten()) { System.out.println("G: Nie."); }
            }
        }
    }
    public void calculateMeal() {
        int tempVegan = 0, tempVegetarian = 0, tempHasLactose = 0, tempHasPeanuts = 0, tempHasGluten = 0, tempIsForDiabetic = 0;

            for (int i = 0; i < listOfProductsInMeal.size(); i++) {
                Product product = listOfProductsInMeal.get(i);

                // Calculating macronutiens of meal
               setCalories(getCalories()+((product.getCalories()*weightOfProducts.get(i))/100));
                setProtein(getProtein()+((product.getProtein()*weightOfProducts.get(i))/100));
                setFat(getFat()+((product.getFat()*weightOfProducts.get(i))/100));
                setCarbohydrates(getCarbohydrates()+((product.getCarbohydrates()*weightOfProducts.get(i))/100));

                // Marking meal which patient can eat it
                if(product.isVegan()){ tempVegan++; }
                if(product.isVegetarian()){ tempVegetarian++; }
                if(product.isHasLactose()){ tempHasLactose++; }
                if(product.isHasPeanuts()){ tempHasPeanuts++; }
                if(product.isHasGluten()){ tempHasGluten++; }
                if(product.isForDiabetic()){ tempIsForDiabetic++; }
            }
        if(tempVegan == listOfProductsInMeal.size()){ setVegan(true); }
        if(tempVegetarian == listOfProductsInMeal.size()){ setVegetarian(true); }
        if(tempHasLactose == 0){ setHasLactose(false); }
        if(tempHasGluten == 0){ setHasGluten(false); }
        if(tempHasPeanuts == 0){ setHasPeanuts(false); }
        if(tempIsForDiabetic == listOfProductsInMeal.size()){ setForDiabetic(true); }
    }


    }


