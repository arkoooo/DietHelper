package com.DietHelper;

import java.util.LinkedList;
import java.util.List;

import static com.DietHelper.Meal.weightOfProducts;
import static com.DietHelper.Product.listOfProducts;
import static com.DietHelper.Sentences.isThatGoodChoice;
import static com.DietHelper.Sentences.wrongChoice;
import static com.DietHelper.UserInputs.getInputFromUser;
import static com.DietHelper.Variables.*;

public class Diet {
    private int calories, numberOfMeals, patientID;
    private List<Meal> allMeals = new LinkedList<>();
    private List<Meal> day1 = new LinkedList<>();
    private List<Meal> day2 = new LinkedList<>();
    private List<Meal> day3 = new LinkedList<>();
    private List<Meal> day4 = new LinkedList<>();
    private List<Meal> day5 = new LinkedList<>();
    private List<Meal> day6 = new LinkedList<>();
    private List<Meal> day7 = new LinkedList<>();

    public Diet() {
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public void setNumberOfMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public static void createDiet() {
        int caloriesPerMeal = 0;
        Patient actualPatient = patientList.get(selectedPatient-1);
        Diet diet = new Diet();
        diet.setPatientID(selectedPatient-1);

        getLikedProducts();
        System.out.println("BMR pacjenta to: " + actualPatient.getBmr() + ", a podaż kalorii potrzebna do utrzymania wagi to: " + actualPatient.getCalories() + "." );
        getInputFromUser("Jaką ilość kalorii ustalasz dla pacjenta?",actualPatient.getCalories()/5,actualPatient.getCalories()*5);
        diet.setCalories(choice);
        getInputFromUser("Ile posiłków ustalasz?",1,8);
        diet.setNumberOfMeals(choice);

        caloriesPerMeal = diet.getCalories()/diet.getNumberOfMeals();
    }
    public static void getLikedProducts(){
        Patient actualPatient = patientList.get(selectedPatient-1);
        listOfProducts();
        System.out.println("Wybierz lubiane przez pacjenta produkty.");
        do {
            System.out.println("Wpisz numer i zatwierdź enterem. Jeżeli chcesz zakończyć wprowadzać produkty wpisz 0. ");
            if (Variables.scanner.hasNextInt()) {
                Variables.choice = Variables.scanner.nextInt();
                Variables.scanner.nextLine();
                if(scanner.nextInt() == 0){
                    break;
                }if (isThatGoodChoice(Variables.choice, 1, productsList.size())) {
                    actualPatient.likedProducts.add(choice-1);
                    Variables.goodChoice = true;
                } else {
                    wrongChoice();
                    Variables.goodChoice = false;
                }
            } else {
                Variables.scanner.nextLine();
                Variables.goodChoice = false;
                wrongChoice();
            }
        } while (!Variables.goodChoice || choice != 0);

        listOfProducts();
        System.out.println("Wybierz nielubiane przez pacjenta produkty.");
        do {
            System.out.println("Wpisz numer i zatwierdź enterem. Jeżeli chcesz zakończyć wprowadzać produkty wpisz 0. ");
            if (Variables.scanner.hasNextInt()) {
                Variables.choice = Variables.scanner.nextInt();
                Variables.scanner.nextLine();
                if(scanner.nextInt() == 0){
                    break;
                }if (isThatGoodChoice(Variables.choice, 1, productsList.size())) {
                    actualPatient.unlikedProducts.add(choice-1);
                    Variables.goodChoice = true;
                } else {
                    wrongChoice();
                    Variables.goodChoice = false;
                }
            } else {
                Variables.scanner.nextLine();
                Variables.goodChoice = false;
                wrongChoice();
            }
        } while (!Variables.goodChoice || choice != 0);
    }
}
