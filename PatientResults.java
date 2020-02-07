package com.dietHelper;

import java.util.LinkedList;
import java.util.List;

import static com.dietHelper.Add.patientList;
import static com.dietHelper.DoctorMenu.patientAdmMenu;
import static com.dietHelper.Main.*;
import static com.dietHelper.Sentences.*;
import static com.dietHelper.TypeOfResults.*;

public class PatientResults {
    static List<Result> resultsList = new LinkedList<>();
    public static int selectedPatient = 0;
    static int numberOfResults;

     public static void resultMenu() {
        do {
            patientResultsMenu();
            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if(isThatGoodChoice(choice,1,3)){
                    goodChoice = true;
                }else{
                    choice = 0;
                    wrongChoice();
                }
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!isThatGoodChoice(choice,1,3));

        switch(choice){
            case 1:
                actualPatientSentence();
                System.out.println("Wpisz numer pacjenta, aby zmienić obecny wybór na inny.");
                for (Patient patient: patientList ){
                    System.out.println("ID: " + patient.getId() + ". Imię: " + patient.getName() + " Nazwisko: "
                            + patient.getSurname());
                }
                break;
            case 2:
                numberOfResults++;
                Result glycemia = new Result(numberOfResults, selectedPatient, GLYCEMIA);
                resultsList.add(glycemia);
                System.out.println("Podaj glikemię na czczo:");
                if (scanner.hasNextInt()) {
                    glycemia.setFirstResult(scanner.nextInt());
                    scanner.nextLine();
                    if (glycemia.getFirstResult() > 0) {
                        goodChoice = true;
                    } else {
                        wrongChoice();
                    }
                } else {
                    scanner.nextLine();
                    wrongChoice();
                }
                System.out.println("Podaj glikemię 1h po przyjęciu glukozy");
                if (scanner.hasNextInt()) {
                    glycemia.setSecondResult(scanner.nextInt());
                    scanner.nextLine();
                    if (glycemia.getSecondResult() > 0) {
                        goodChoice = true;
                    } else {
                        wrongChoice();
                    }
                } else {
                    scanner.nextLine();
                    wrongChoice();
                }
                System.out.println("Podaj glikemię 2h po przyjęciu glukozy");
                if (scanner.hasNextInt()) {
                    glycemia.setThirdResult(scanner.nextInt());
                    scanner.nextLine();
                    if (glycemia.getThirdResult() > 0) {
                        goodChoice = true;
                    } else {
                        wrongChoice();
                    }
                } else {
                    scanner.nextLine();
                    wrongChoice();
                }
                break;
            case 3:
                numberOfResults++;
                Result insulin = new Result(numberOfResults, selectedPatient,INSULIN);
                resultsList.add(insulin);
                System.out.println("Podaj insulinę na czczo:");
                if (scanner.hasNextInt()) {
                    insulin.setFirstResult(scanner.nextInt());
                    scanner.nextLine();
                    if (insulin.getFirstResult() > 0) {
                        goodChoice = true;
                    } else {
                        wrongChoice();
                    }
                } else {
                    scanner.nextLine();
                    wrongChoice();
                }
                System.out.println("Podaj insulinę 1h po przyjęciu glukozy");
                if (scanner.hasNextInt()) {
                    insulin.setSecondResult(scanner.nextInt());
                    scanner.nextLine();
                    if (insulin.getSecondResult() > 0) {
                        goodChoice = true;
                    } else {
                        wrongChoice();
                    }
                } else {
                    scanner.nextLine();
                    wrongChoice();
                }
                System.out.println("Podaj insulinę 2h po przyjęciu glukozy");
                if (scanner.hasNextInt()) {
                    insulin.setThirdResult(scanner.nextInt());
                    scanner.nextLine();
                    if (insulin.getThirdResult() > 0) {
                        goodChoice = true;
                    } else {
                        wrongChoice();
                    }
                } else {
                    scanner.nextLine();
                    wrongChoice();
                }
                break;
            case 4:
                patientAdmMenu();
                break;
        }
    }

}
