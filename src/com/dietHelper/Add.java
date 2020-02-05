package com.dietHelper;

import static com.dietHelper.Main.*;
import static com.dietHelper.Sentences.*;

public class Add {
    public static int numberOfPatients = 0;
    public static void newPatient(){
        Patient patient = new Patient();

        numberOfPatients++;
        patient.setId(numberOfPatients);

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

        // Reset good choice value to default
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

        goodChoice = false;

        // Calculate BMR and calories intake by methods
        patient.calculateBmr();
        patient.calculateTotalMetabolism();

        //Display patient data
        System.out.println("Utworzono nowego pacjenta: "  +  patient.getName() + " " + patient.getSurname() + "\n" +
                "Płeć: " + patient.changeGender() + "\n" +
                "Wiek: " + patient.getAge() + "\n" +
                "Waga: " + patient.getWeight() + "\n" +
                "Wzrost: " + patient.getHeight() + "\n" +
                "Aktywność: " + patient.getActivity() + "\n" +
                "Wyliczony BMR: " + patient.getBmr()  + " kcal" + "\n" +
                "Zapotrzebowanie kaloryczne: " + patient.getCalories() + " kcal"
        );

        System.out.println("Przeprowadź wywiad z pacjentem. \n" +
                "Jeżeli pacjent odpowie tak: wpisz 1, jeżeli nie: wpisz 0");
        do {
            System.out.println("Czy pacjent ma nietolerancję na orzechy?");
            if(scanner.hasNextInt()) {
                patient.setPeanuts(scanner.nextInt());
                scanner.nextLine();
                if(patient.getPeanuts() == 1 || patient.getPeanuts() == 0){
                    goodChoice = true;
                }else{
                    wrongChoice();
                }
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!goodChoice);

        // Reset good choice value to default
        goodChoice = false;

        do {
            System.out.println("Czy ma nietolerancję laktozy?");
            if(scanner.hasNextInt()) {
                patient.setLactose(scanner.nextInt());
                scanner.nextLine();
                if(patient.getLactose() == 1 || patient.getLactose() == 0){
                    goodChoice = true;
                }else{
                    wrongChoice();
                }
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!goodChoice);

        // Reset good choice value to default
        goodChoice = false;

        do {
            System.out.println("Czy ma stwierdzoną insulinooporność(1)/hiperinsulinemię(2)/hipoglikemię " +
                    "reaktywną(3)/cukrzycę(4)? Wpisz odpowiednią cyfrę jeżeli tak, 0 jeżeli brak.");
            if(scanner.hasNextInt()) {
                patient.setDiabetes(scanner.nextInt());
                scanner.nextLine();
                if(patient.getDiabetes() >= 0 && patient.getDiabetes() < 5){
                    goodChoice = true;
                }else{
                    wrongChoice();
                }
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!goodChoice);

        // Reset good choice value to default
        goodChoice = false;

        if(patient.getDiabetes() > 0){
            System.out.println("Jeżeli pacjent ma stwierdzone problemy z gospodarką insulinową, konieczne jest wypełnienie wywiadu pacjenta " +
                    "w którym zawarte będą dokładne wyniki glukozy oraz insuliny we krwi po obciążeniu glukozą");
        }

        //The result of insulin and glucose will be taken only if the problems are not officially identified. Otherwise, the doctor fills in the patient's results
        if(patient.getDiabetes() == 0) {
            do {
                System.out.println("Podaj wynik insuliny na czczo: [mU/ml]");
                if (scanner.hasNextInt()) {
                    patient.setInsulin(scanner.nextInt());
                    scanner.nextLine();
                    if (patient.getInsulin() > 0) {
                        goodChoice = true;
                    } else {
                        wrongChoice();
                    }
                } else {
                    scanner.nextLine();
                    wrongChoice();
                }
            } while (!goodChoice);
        }

        // Reset good choice value to default
        goodChoice = false;

        if(patient.getDiabetes() == 0) {
            do {
                System.out.println("Podaj wynik glikemii na czczo [mmol/l]:");
                if (scanner.hasNextInt()) {
                    patient.setGlycemia(scanner.nextInt());
                    scanner.nextLine();
                    if (patient.getGlycemia() > 0) {
                        goodChoice = true;
                    } else {
                        wrongChoice();
                    }
                } else {
                    scanner.nextLine();
                    wrongChoice();
                }
            } while (!goodChoice);
        }

        // Reset good choice value to default
        goodChoice = false;


        do {
            System.out.println("Czy jest weganem?");
            if(scanner.hasNextInt()) {
                patient.setVegan(scanner.nextInt());
                scanner.nextLine();
                if(patient.getVegan() == 1 || patient.getVegan() == 0){
                    goodChoice = true;
                }else{
                    wrongChoice();
                }
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!goodChoice);

        // Reset good choice value to default
        goodChoice = false;

        if(patient.getVegan() == 0) {
            do {
                System.out.println("Czy pacjent jest wegetarianinem?");
                if (scanner.hasNextInt()) {
                    patient.setVegetarian(scanner.nextInt());
                    scanner.nextLine();
                    if (patient.getVegetarian() == 1 || patient.getVegetarian() == 0) {
                        goodChoice = true;
                    } else {
                        wrongChoice();
                    }
                } else {
                    scanner.nextLine();
                    wrongChoice();
                }
            } while (!goodChoice);
        }else {
            patient.setVegetarian(1);
        }

        // Reset good choice value to default
        goodChoice = false;


    /**
        do {
            System.out.println("Wpisz ulubione produkty:");
            goodChoice = true;
        }while(!goodChoice);

        // Reset good choice value to default
        goodChoice = false;

        do {
            System.out.println("Wpisz nielubiane produkty:");
            goodChoice = true;
        }while(!goodChoice);

        // Reset good choice value to default
        goodChoice = false;
    **/
    patient.homaIR();
    patient.checkHomaIR();

    if(patient.getDiabetes() > 0){
        if(patient.checkHomaIR()){
            System.out.println("Pacjent ma podejrzenie insulinooporności - wykryto nieprawidłowy wskaźnik Homa-IR: " + patient.homaIR() + ". Zaleca się wykonanie badań pod " +
                    "obciążeniem glukozą. Wyniki można wpisać w sekcji 'Wyniki pacjenta'");
        }else {
            System.out.println("Pacjent ma problemy z gospodarką insulinową. Zaleca się wykonanie badań pod obciążeniem glukozą. " +
                    "Wyniki można wpisać w sekcji 'Wyniki pacjenta'");
        }
    }

        //Go back to doctor menu
        // DoctorMenu.choice = 0;
        DoctorMenu.doctorFirstMenu();
    }
    public static void newMeal() {
        Meal meal = new Meal();
    }
    public static void newProduct(){
        Product product = new Product();
    }
}
