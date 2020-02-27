package com.DietHelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.DietHelper.Meal.listOfMeals;
import static com.DietHelper.Variables.*;
import static org.junit.jupiter.api.Assertions.*;

class DietTest {
    Patient veganPatient = new Patient();
    Diet veganPatientDiet = new Diet();
    Patient diabeticPatient = new Patient();
    Diet diabeticPatientDiet = new Diet();

    @BeforeEach
    public void setUp(){
        Examples.createExampleProducts();
        Examples.createExampleMeals();
        veganPatient.setDietId(1);
        veganPatient.setId(1);
        veganPatient.setWeight(95);
        veganPatient.setHeight(182);
        veganPatient.setActivity(2);
        veganPatient.setGender(1);
        veganPatient.calculateBmr();
        veganPatient.calculateTotalMetabolism();
        veganPatient.setVegan(1);
        veganPatientDiet.setPatientID(1);
        veganPatientDiet.setCalories(2500);
        veganPatientDiet.setNumberOfMeals(5);
        veganPatientDiet.setCaloriesPerMeal(veganPatientDiet.getCalories()/veganPatientDiet.getNumberOfMeals());
        dietsList.add(veganPatientDiet);
        patientList.add(veganPatient);
        diabeticPatient.setDietId(2);
        diabeticPatient.setId(2);
        diabeticPatient.setWeight(95);
        diabeticPatient.setHeight(182);
        diabeticPatient.setActivity(2);
        diabeticPatient.setGender(1);
        diabeticPatient.calculateBmr();
        diabeticPatient.calculateTotalMetabolism();
        diabeticPatient.setDiabetes(1);
        diabeticPatient.setVegan(0);
        diabeticPatientDiet.setCalories(2500);
        diabeticPatientDiet.setNumberOfMeals(5);
        diabeticPatientDiet.setCaloriesPerMeal(diabeticPatientDiet.getCalories()/diabeticPatientDiet.getNumberOfMeals());
        dietsList.add(diabeticPatientDiet);
        patientList.add(diabeticPatient);
    }


    @Test
    void getMealsToDiet() {
        //arrange
        selectedPatient = 1;
        veganPatientDiet.getMealsToDiet();
        selectedPatient = 2;
        diabeticPatientDiet.getMealsToDiet();
        int nonDiabeticMealsInDiet = 0;
        int nonVeganMealsInDiet = 0;
        //act
        for (int i = 0; i < veganPatientDiet.getAllMeals().size(); i++) {
            if(!veganPatientDiet.getAllMeals().get(i).isVegan()){
                nonVeganMealsInDiet++;
            }
        }
        for (int i = 0; i < diabeticPatientDiet.getAllMeals().size(); i++) {
            if(!diabeticPatientDiet.getAllMeals().get(i).isForDiabetic()){
                nonDiabeticMealsInDiet++;
            }
        }
        //assert
        assertEquals(0,nonDiabeticMealsInDiet);
        assertFalse(diabeticPatientDiet.getAllMeals().isEmpty());
        assertEquals(0,nonVeganMealsInDiet);
        assertFalse(veganPatientDiet.getAllMeals().isEmpty());
    }

    @Test
    void arrangeMeals() {
    }
}