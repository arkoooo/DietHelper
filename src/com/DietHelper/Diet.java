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

    public  List<Meal> getDay1() {
        return day1;
    }

    public static void setDay1(List<Meal> day1) {
        Diet.day1 = day1;
    }

    public List<Meal> getDay2() {
        return day2;
    }

    public static void setDay2(List<Meal> day2) {
        Diet.day2 = day2;
    }

    public  List<Meal> getDay3() {
        return day3;
    }

    public static void setDay3(List<Meal> day3) {
        Diet.day3 = day3;
    }

    public  List<Meal> getDay4() {
        return day4;
    }

    public static void setDay4(List<Meal> day4) {
        Diet.day4 = day4;
    }

    public  List<Meal> getDay5() {
        return day5;
    }

    public static void setDay5(List<Meal> day5) {
        Diet.day5 = day5;
    }

    public  List<Meal> getDay6() {
        return day6;
    }

    public static void setDay6(List<Meal> day6) {
        Diet.day6 = day6;
    }

    public  List<Meal> getDay7() {
        return day7;
    }

    public static void setDay7(List<Meal> day7) {
        Diet.day7 = day7;
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

        arrangeWholeDiet(diet);
    }

    public static void arrangeWholeDiet(Diet diet) {
        diet.arrangeDay(day1);
        diet.arrangeDay(day2);
        diet.arrangeDay(day3);
        diet.arrangeDay(day4);
        diet.arrangeDay(day5);
        diet.arrangeDay(day6);
        diet.arrangeDay(day7);
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
    public void arrangeDay(List<Meal> day){
        Patient actualPatient = patientList.get(selectedPatient - 1);
        Diet actualPatientDiet = dietsList.get(actualPatient.getDietId() - 1);
        Random generator = new Random();

        // Arranging breakfast
        for (int i = 0; i < actualPatientDiet.allMeals.size(); i++) {
            if(actualPatientDiet.allMeals.get(i).getTypeOfMeal() == TypeOfMeal.BREAKFAST){
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
