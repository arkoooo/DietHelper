package com.dietHelper;

public class Patient {
     private String name, surname;
     private int weight, gender, age, height, activity, calories, bmr, insulin, glucoze;
     boolean peanuts, lactose, diabetes, hipoglikemia, hiperinsulinemia, insulinResistance, vegan, vegetarian;
     int[] likedProducts, unLikedProducts;

    public Patient() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public boolean isPeanuts() {
        return peanuts;
    }

    public void setPeanuts(boolean peanuts) {
        this.peanuts = peanuts;
    }

    public boolean isLactose() {
        return lactose;
    }

    public void setLactose(boolean lactose) {
        this.lactose = lactose;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isHipoglikemia() {
        return hipoglikemia;
    }

    public void setHipoglikemia(boolean hipoglikemia) {
        this.hipoglikemia = hipoglikemia;
    }

    public boolean isHiperinsulinemia() {
        return hiperinsulinemia;
    }

    public void setHiperinsulinemia(boolean hiperinsulinemia) {
        this.hiperinsulinemia = hiperinsulinemia;
    }

    public boolean isInsulinResistance() {
        return insulinResistance;
    }

    public void setInsulinResistance(boolean insulinResistance) {
        this.insulinResistance = insulinResistance;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int[] getLikedProducts() {
        return likedProducts;
    }

    public void setLikedProducts(int[] likedProducts) {
        this.likedProducts = likedProducts;
    }

    public int[] getUnLikedProducts() {
        return unLikedProducts;
    }

    public void setUnLikedProducts(int[] unLikedProducts) {
        this.unLikedProducts = unLikedProducts;
    }

    public int getInsulin() {
        return insulin;
    }

    public void setInsulin(int insulin) {
        this.insulin = insulin;
    }

    public int getGlucoze() {
        return glucoze;
    }

    public void setGlucoze(int glucoze) {
        this.glucoze = glucoze;
    }



    /** Calculating BMR according to the Mifflin-St Jeor formula */
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

        /** Calculation of total calories by activity */
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

}
