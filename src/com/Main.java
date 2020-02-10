package com.DietHelper;

import static com.DietHelper.Sentences.*;
import static com.DietHelper.Variables.*;

public class Main {

    public static void main(String[] args) {
                createExamplePatients();
                mainMenu();
    }

    private static void createExamplePatients() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Arek");
        patient.setSurname("Kubek");
        patient.setGender(1);
        patient.setWeight(95);
        patient.setHeight(185);
        patient.setYear(1994);
        patient.setActivity(2);
        patient.calculateBmr();
        patient.calculateTotalMetabolism();

        Patient patient2 = new Patient();
        patient2.setId(2);
        patient2.setName("Paula");
        patient2.setSurname("Sedi");
        patient2.setGender(2);
        patient2.setWeight(55);
        patient2.setHeight(150);
        patient2.setYear(1995);
        patient2.setActivity(3);
        patient2.calculateBmr();
        patient2.calculateTotalMetabolism();

        patientList.add(patient);
        patientList.add(patient2);
        selectedPatient = 1;

        Product product = new Product();
        Product product2 = new Product();

        product.setName("Ryż basmati");
        product.setProtein(5);
        product.setHasGluten(false);
        product.setVegetarian(true);
        product.setHasPeanuts(false);
        product.setHasLactose(false);
        product.setForDiabetic(true);
        product.setCarbohydrates(60);
        product.setFat(5);
        product.setCalories(360);
        product.setVegan(true);

        product2.setName("Kurczak");
        product2.setProtein(24);
        product2.setHasGluten(false);
        product2.setVegetarian(false);
        product2.setHasPeanuts(false);
        product2.setHasLactose(false);
        product2.setForDiabetic(true);
        product2.setCarbohydrates(5);
        product2.setFat(5);
        product2.setCalories(200);
        product2.setVegan(false);

        productsList.add(product);
        productsList.add(product2);

    }

    public static void mainMenu() {
            do{
                //The first time run of program greeting is displayed
                if(Variables.isNeededGreetings){
                    hello();
                    Variables.isNeededGreetings = false;
                }
                System.out.println(mainMenuSentence());
                if(Variables.scanner.hasNextInt()) { // If user type character then menu will be listed once again
                    Variables.choice = Variables.scanner.nextInt();
                }else{
                    Variables.goodChoice = false;
                    wrongChoice();
                }
                Variables.scanner.nextLine();
            }while(!isThatGoodChoice(Variables.choice,1,3) && !Variables.goodChoice); //Menu will be displayed until user type correct input



            switch (Variables.choice){
                case 1:
                    PatientMenu.patientMenu();
                    //isThatInt = true;
                    break;
                case 2:
                    DoctorMenu.doctorFirstMenu();
                    //isThatInt = true;
                    break;
                case 3:
                    break;
            }
        }
    }

