package com.dietHelper;

import static com.dietHelper.Main.scanner;
import static com.dietHelper.Sentences.*;

public class Adding {
    public static void newPatient(){
        String name, surname;
        int weight = 0, gender = 0, age = 0, height = 0, bmr = 0, activity = 0, calories = 0;

        Patient patient = new Patient();
        boolean goodChoice = false;

        typeName();
        patient.setName(scanner.nextLine());
        typeSurname();
        patient.setSurname(scanner.nextLine());

        do {
            typeGender();
                if(scanner.hasNextInt()) {
                    patient.setGender(scanner.nextInt());
                    scanner.nextLine();
                    if(patient.getGender() == 1 || patient.getGender() == 2){
                        goodChoice = true;
                    }else{
                        wrongChoice();
                    }
                }else{
                    scanner.nextLine();
                    wrongChoice();
                }
        }while(!goodChoice);

        /* Reset goodChoice to default value */
        goodChoice = false;

        do {
            typeAge();
            if(scanner.hasNextInt()) {
                patient.setAge(scanner.nextInt());
                scanner.nextLine();
                if(patient.getAge() > 0 && patient.getAge() < 120){
                    goodChoice = true;
                }else{
                    wrongChoice();
                }
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!goodChoice);

        /* Reset goodChoice to default value */
        goodChoice = false;

        do {
            typeWeight();
            if(scanner.hasNextInt()) {
                patient.setWeight(scanner.nextInt());
                scanner.nextLine();
                if(patient.getWeight() > 0 && patient.getWeight() < 300){
                    goodChoice = true;
                }else{
                    wrongChoice();
                }
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!goodChoice);

        /* Reset goodChoice to default value */
        goodChoice = false;

        do {
            typeHeight();
            if(scanner.hasNextInt()) {
                patient.setHeight(scanner.nextInt());
                scanner.nextLine();
                if(patient.getHeight() > 0 && patient.getHeight() < 300){
                    goodChoice = true;
                }else{
                    wrongChoice();
                }
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!goodChoice);

        /* Reset goodChoice to default value */
        goodChoice = false;

        do {
            typeActivity();
            if(scanner.hasNextInt()) {
                patient.setActivity(scanner.nextInt());
                scanner.nextLine();
                if(patient.getActivity() > 0 && patient.getActivity() <= 5){
                    goodChoice = true;
                }else{
                    wrongChoice();
                }
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!goodChoice);

        // Calculating BMR and calculating calories intake by methods
        patient.calculateBmr();
        patient.calculateTotalMetabolism();

        System.out.println("Utworzono nowego pacjenta: "  +  patient.getName() + " " + patient.getSurname() + "\n" +
                "Płeć: " + patient.changeGender() + "\n" +
                "Wiek: " + patient.getAge() + "\n" +
                "Waga: " + patient.getWeight() + "\n" +
                "Wzrost: " + patient.getHeight() + "\n" +
                "Aktywność: " + patient.getActivity() + "\n" +
                "Wyliczony BMR: " + patient.getBmr()  + " kcal" + "\n" +
                "Zapotrzebowanie kaloryczne: " + patient.getCalories() + " kcal"
        );

        /* Going back to Doctor Menu */
        DoctorMenu.choice = 0;
        DoctorMenu.doctorFirstMenu();
    }

    public static void newMeal() {
        Meal meal = new Meal();
    }
    public static void newProduct(){
        Product product = new Product();
    }
}
