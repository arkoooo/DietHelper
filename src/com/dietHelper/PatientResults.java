package com.dietHelper;

import static com.dietHelper.DoctorMenu.patientAdmMenu;
import static com.dietHelper.Main.*;
import static com.dietHelper.Sentences.*;
import static com.dietHelper.TypeOfResults.*;

public class PatientResults {
    static int numberOfGlucoseResults = 0, numberOfInsulinResults = 0;
     public static void resultMenu() {
        do {
            System.out.println("Wpisz wynik pacjenta: \n" +
                    "1. Wybierz pacjenta \n" +
                    "2. Glukoza \n" +
                    "3. Insulina \n" +
                    "4. Powrót do poprzedniego menu \n" +
                    "Wpisz numer:");
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
                System.out.println("Aktualnie wybrany pacjent: ID:" + "Imię: " + "Nazwisko: ");
                System.out.println("Wpisz numer pacjenta, aby zmienić obecny wybór na inny.");
                break;
            case 2:
                numberOfGlucoseResults++;
                Result glycemia = new Result(numberOfGlucoseResults, 1, GLYCEMIA);
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
                numberOfInsulinResults++;
                Result insulin = new Result(numberOfInsulinResults, 1,INSULIN);
                System.out.println("Podaj glikemię na czczo:");
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
                System.out.println("Podaj glikemię 1h po przyjęciu glukozy");
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
                System.out.println("Podaj glikemię 2h po przyjęciu glukozy");
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
