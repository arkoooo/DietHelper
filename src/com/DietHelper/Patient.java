package com.DietHelper;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static com.DietHelper.Variables.selectedPatient;

public class Patient {
     private String name, surname;
     private int id, weight, gender, year, height, activity, calories, bmr, insulin, glycemia, peanuts, lactose, diabetes, vegan, vegetarian, gluten, dietId;
     List<Integer> likedProducts = new LinkedList<>();
     List<Integer> unlikedProducts = new LinkedList<>();

    public Patient() {
    }

    public static void writePatientList() {
        for (int i = 0; i < Variables.patientList.size(); i++) {
            System.out.print(Variables.patientList.get(i).getId() + ". " + Variables.patientList.get(i).getName() + " " + Variables.patientList.get(i).getSurname());
            if (i == selectedPatient - 1) {
                System.out.print(" <- Aktualnie wybrany pacjent. \n");
            }else{
                System.out.println("");
            }
        }
        System.out.println("");
    }

    public int getId() { return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getBmr() {
        return bmr;
    }

    public void setBmr(int bmr) {
        this.bmr = bmr;
    }

    public int getInsulin() {
        return insulin;
    }

    public void setInsulin(int insulin) {
        this.insulin = insulin;
    }

    public int getGlycemia() {
        return glycemia;
    }

    public void setGlycemia(int glycemia) {
        this.glycemia = glycemia;
    }

    public int getPeanuts() {
        return peanuts;
    }

    public void setPeanuts(int peanuts) {
        this.peanuts = peanuts;
    }

    public int getLactose() {
        return lactose;
    }

    public void setLactose(int lactose) {
        this.lactose = lactose;
    }

    public int getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    public int getVegan() {
        return vegan;
    }

    public void setVegan(int vegan) {
        this.vegan = vegan;
    }

    public int getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(int vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getGluten() {
        return gluten;
    }

    public void setGluten(int gluten) {
        this.gluten = gluten;
    }
    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }

    //Calculating BMR according to the Mifflin-St Jeor formula
    public void calculateBmr(){
        switch(getGender()){
            case 1:
                setBmr((int) ((9.99 * getWeight()) + (6.25 * getHeight()) - (4.92 * getAge()) + 5));
                break;
            case 2:
                setBmr((int) ((9.99 * getWeight()) + (6.25 * getHeight()) - (4.92 * getAge()) - 161));
                break;
            default:
                setBmr(0);
        }
    }

    public void calculateTotalMetabolism(){
        //Calculation of total calories depends on activity *
        switch(getActivity()){
            case 1:
                setCalories((int) (bmr * 1.2));
                break;
            case 2:
                setCalories((int) (bmr * 1.35));
                break;
            case 3:
                setCalories((int) (bmr * 1.55));
                break;
            case 4:
                setCalories((int) (bmr * 1.75));
                break;
            case 5:
                setCalories((int) (bmr * 2.05));
                break;
            default:
                setCalories(0);
        }
    }

    //Change int number to a word representing gender
    public String changeGender(){
        String changedGender;
        switch(getGender()){
            case 1:
                changedGender = "Mężczyzna";
                break;
            case 2:
                changedGender =  "Kobieta";
                break;
            default:
                changedGender = "Błąd";
        }
        return changedGender;
    }

    public double homaIR(){
        double homaIR;
        homaIR = (getInsulin()* getGlycemia()) / 400.0;
        return homaIR;
    }
    public boolean checkHomaIR(){
        boolean badHomaIR;
        if(homaIR() >= 2.5){
            setDiabetes(1);
            badHomaIR = true;
        }else{
            badHomaIR = false;
        }
        return badHomaIR;
    }

    public int getAge(){
        return Calendar.getInstance().get(Calendar.YEAR)-getYear();
    }


}
