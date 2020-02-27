package com.DietHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static com.DietHelper.Meal.listOfMeals;
import static com.DietHelper.Product.listOfProducts;
import static com.DietHelper.Sentences.*;
import static com.DietHelper.UserInputs.getInputFromUser;
import static com.DietHelper.Variables.*;

public class Diet {
    private int calories, numberOfMeals, patientID, caloriesPerMeal;



    private List<Meal> allMeals = new LinkedList<>();
    private static List<Meal> day1 = new LinkedList<>();
    private static List<Meal> day2 = new LinkedList<>();
    private static List<Meal> day3 = new LinkedList<>();
    private static List<Meal> day4 = new LinkedList<>();
    private static List<Meal> day5 = new LinkedList<>();
    private static List<Meal> day6 = new LinkedList<>();
    private static List<Meal> day7 = new LinkedList<>();

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

    public int getCaloriesPerMeal() {
        return caloriesPerMeal;
    }

    public void setCaloriesPerMeal(int caloriesPerMeal) {
        this.caloriesPerMeal = caloriesPerMeal;
    }

    public List<Meal> getAllMeals() {
        return allMeals;
    }

    public void setAllMeals(List<Meal> allMeals) {
        this.allMeals = allMeals;
    }

    public static void createDiet() {
        Patient actualPatient = patientList.get(selectedPatient-1);
        Diet diet = new Diet();
        diet.setPatientID(selectedPatient);
        actualPatient.setDietId(dietsList.size()+1);

        getDislikedProducts();
        System.out.println("BMR pacjenta to: " + actualPatient.getBmr() + ", a podaż kalorii potrzebna do utrzymania wagi to: " + actualPatient.getCalories() + "." );
        getInputFromUser("Jaką ilość kalorii ustalasz dla pacjenta?",actualPatient.getCalories()/5,actualPatient.getCalories()*5);
        diet.setCalories(choice);
        getInputFromUser("Ile posiłków ustalasz?",1,8);
        diet.setNumberOfMeals(choice);

        //Calculation of calories for one meal, assuming that everyone will have similar calories
        diet.setCaloriesPerMeal(diet.getCalories()/diet.getNumberOfMeals());

        dietsList.add(diet);
        diet.getMealsToDiet();

        diet.arrangeMeals(day1);
        diet.arrangeMeals(day2);
        diet.arrangeMeals(day3);
        diet.arrangeMeals(day4);
        diet.arrangeMeals(day5);
        diet.arrangeMeals(day6);
        diet.arrangeMeals(day7);

    }

    public static void getDislikedProducts(){
        Patient actualPatient = patientList.get(selectedPatient-1);
        listOfProducts();
        /**
        System.out.println("Wybierz lubiane przez pacjenta produkty.");
        do {
            System.out.println("Wpisz numer i zatwierdź enterem. Jeżeli chcesz zakończyć wprowadzać produkty wpisz 0. ");
            if (Variables.scanner.hasNextInt()) {
                Variables.choice = Variables.scanner.nextInt();
                Variables.scanner.nextLine();
                if(choice == 0){ break; }
                if (isThatGoodChoice(Variables.choice, 1, productsList.size())) {
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
        **/
        System.out.println("Wybierz nielubiane przez pacjenta produkty.");
        do {
            System.out.println("Wpisz numer i zatwierdź enterem. Jeżeli chcesz zakończyć wprowadzać produkty wpisz 0. ");
            if (Variables.scanner.hasNextInt()) {
                Variables.choice = Variables.scanner.nextInt();
                Variables.scanner.nextLine();
                // If user type 0, then adding disliked products will break.
                if(choice == 0){
                    break;
                }if (UserInputs.isThatGoodChoice(Variables.choice, 1, productsList.size())) {
                    actualPatient.dislikedProducts.add(productsList.get(choice));
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
    public void getMealsToDiet() {
        Patient actualPatient = patientList.get(selectedPatient - 1);
        Diet actualPatientDiet = dietsList.get(actualPatient.getDietId() - 1);
        boolean canAddMeal;

        for (int i = 0; i < mealsList.size(); i++) {
            // Check if the meal's calories match with accepted calories per meal. Margin of fault is 100 calories.
            if (mealsList.get(i).getCalories() >= (caloriesPerMeal - 100) && mealsList.get(i).getCalories() <= (caloriesPerMeal + 100)) {
                canAddMeal = true;
            }else{
                canAddMeal = false;
            }
            // Check if product from actually checked meal is in disliked list, then program will not add this meal to diet.
            for (int j = 0; j < mealsList.get(i).listOfProductsInMeal.size(); j++) {
                if (actualPatient.dislikedProducts.contains(mealsList.get(i).listOfProductsInMeal.get(j))) {
                    canAddMeal = false;
                }
            }
            // Checking patient problems/recommendations
            if(actualPatient.getVegan() == 1){
                if(!mealsList.get(i).isVegan()){
                    canAddMeal = false;
                }
            }
            if(actualPatient.getVegetarian() == 1){
                if(!mealsList.get(i).isVegetarian()){
                    canAddMeal = false;
                }
            }
            if(actualPatient.getDiabetes() > 0){
                if(!mealsList.get(i).isForDiabetic()){
                    canAddMeal = false;
                }
            }
            if(actualPatient.getPeanuts() == 1){
                if(mealsList.get(i).isHasPeanuts()){
                    canAddMeal = false;
                }
            }
            if(actualPatient.getGluten() == 1){
                if(mealsList.get(i).isHasGluten()){
                    canAddMeal = false;
                }
            }
            if(actualPatient.getLactose() == 1){
                if(mealsList.get(i).isHasLactose()){
                    canAddMeal = false;
                }
            }
            if (canAddMeal) {
                actualPatientDiet.allMeals.add(mealsList.get(i));
            }
        }
    }
    public void arrangeMeals(List<Meal> day){
        Patient actualPatient = patientList.get(selectedPatient - 1);
        Diet actualPatientDiet = dietsList.get(actualPatient.getDietId() - 1);
        Random generator = new Random();

        // Arranging breakfast
        for (int i = 0; i < actualPatientDiet.allMeals.size(); i++) {
            if(actualPatientDiet.allMeals.get(i).getTypeOfMeal() == TypeOfMeal.BREAKFAST){
                System.out.println("Sprawdzam" + actualPatientDiet.allMeals.get(i).getName() + actualPatientDiet.allMeals.get(i).getTypeOfMeal());
                day.add(actualPatientDiet.allMeals.get(i));
                break;
            }
        }
        // Arranging supper
        for (int i = 0; i < actualPatientDiet.allMeals.size(); i++) {
            if(actualPatientDiet.allMeals.get(i).getTypeOfMeal() == TypeOfMeal.SUPPER){
                day.add(actualPatientDiet.allMeals.get(i));
                break;
            }
        }
        // Arranging other meals
        while(actualPatientDiet.numberOfMeals != day.size()){
            int rand = generator.nextInt(actualPatientDiet.allMeals.size());
            if(actualPatientDiet.allMeals.get(rand).getTypeOfMeal() == TypeOfMeal.ANY || actualPatientDiet.allMeals.get(rand).getTypeOfMeal() == TypeOfMeal.DINNER
                    || actualPatientDiet.allMeals.get(rand).getTypeOfMeal() == TypeOfMeal.SNACK ){
                day.add(1, actualPatientDiet.allMeals.get(rand));
            }
        }
    }

    public static void showDiet() {
        System.out.println("Dzień 1:");
        if(!day1.isEmpty()) {
            listOfMeals(day1);
            }
        System.out.println("Dzień 2:");
        if(!day2.isEmpty()) {
            listOfMeals(day2);
            }
        System.out.println("Dzień 3:");
        if(!day3.isEmpty()) {
            listOfMeals(day3);
            }
        System.out.println("Dzień 4:");
        if(!day4.isEmpty()) {
            listOfMeals(day4);
            }
        System.out.println("Dzień 5:");
        if(!day5.isEmpty()) {
            listOfMeals(day5);
            }
        System.out.println("Dzień 6:");
        if(!day6.isEmpty()) {
            listOfMeals(day6);
            }
        System.out.println("Dzień 7:");
        if(!day7.isEmpty()) {
            listOfMeals(day7);
            }
        }


        public static void showAllPatientMeals(){
            Patient actualPatient = patientList.get(selectedPatient-1);
            if(actualPatient.getDietId()>0) {
                Diet actualPatientDiet = dietsList.get(actualPatient.getDietId() - 1);
                if(!actualPatientDiet.allMeals.isEmpty()) {
                    listOfMeals(actualPatientDiet.allMeals);
                }
            }else{
                System.out.println("Brak diety");
            }




        }


}
