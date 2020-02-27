package com.DietHelper;

import org.junit.jupiter.api.Test;

import static com.DietHelper.Variables.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddTest {
    @Test
    public void newPatient() {
        //arrange
        Patient patient = new Patient();
        patientList.add(patient);
        //act
        int result = patientList.size();
        //assert
        assertEquals(1, result);
    }

    @Test
    void newProduct() {
        //arrange
        Product product = new Product();
        productsList.add(product);
        //act
        int result = productsList.size();
        //assert
        assertEquals(1,result);
    }

    @Test
    void newMeal() {
        //arrange
        Meal meal = new Meal();
        mealsList.add(meal);
        //act
        int result = mealsList.size();
        //assert
        assertEquals(1,result);
    }

    @Test
    void addProductsToMeal() {
        //arrange
        Meal meal = new Meal();
        Examples.createExamplePatients();
        meal.listOfProductsInMeal.add(Variables.productsList.get(0));
        meal.weightOfProducts.add(100);
        //act
        Product product = meal.listOfProductsInMeal.get(0);
        int weightOfProduct = meal.weightOfProducts.get(0);
        //assert
        assertEquals(100,weightOfProduct);
        assertEquals( "Ryż",product.getName());
    }
}