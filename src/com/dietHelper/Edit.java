package com.dietHelper;

import static com.dietHelper.Main.*;
import static com.dietHelper.Sentences.*;

public class Edit {
    public static void editPatient(){
        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
        }
    }

    static void isPatientVegetarian(Patient patient) {
        if(patient.getVegan() == 0) {
            do {
                System.out.println("Czy pacjent jest wegetarianinem?");
                if (scanner.hasNextInt()) {
                    patient.setVegetarian(scanner.nextInt());
                    scanner.nextLine();
                    if(isThatGoodChoice(patient.getVegetarian(),0,2)){
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
        goodChoice = false;
    }

    static void isPatientVegan(Patient patient) {
        do {
            System.out.println("Czy pacjent jest weganem?");
            if(scanner.hasNextInt()) {
                patient.setVegan(scanner.nextInt());
                scanner.nextLine();
                if(isThatGoodChoice(patient.getVegan(),0,2)){
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
    }

    static void editGlycemiaAndInsulin(Patient patient) {
        if (patient.getDiabetes() == 0) {
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
            goodChoice = false;
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
        goodChoice = false;
    }

    static void hasPatientDiabeticProblems(Patient patient) {
        do {
            System.out.println("Czy ma stwierdzoną insulinooporność(1)/hiperinsulinemię(2)/hipoglikemię " +
                    "reaktywną(3)/cukrzycę(4)? Wpisz odpowiednią cyfrę jeżeli tak, 0 jeżeli brak.");
            if (scanner.hasNextInt()) {
                patient.setDiabetes(scanner.nextInt());
                scanner.nextLine();
                if (isThatGoodChoice(patient.getDiabetes(), 0, 5)) {
                    goodChoice = true;
                } else {
                    wrongChoice();
                }
            } else {
                scanner.nextLine();
                wrongChoice();
            }
        } while (!goodChoice);
        goodChoice = false;
    }

    static void isPatientLactoseIntolerant(Patient patient) {
        do {
            System.out.println("Czy ma nietolerancję laktozy?");
            if (scanner.hasNextInt()) {
                patient.setLactose(scanner.nextInt());
                scanner.nextLine();
                if (isThatGoodChoice(patient.getLactose(), 0, 2)) {
                    goodChoice = true;
                } else {
                    wrongChoice();
                }
            } else {
                scanner.nextLine();
                wrongChoice();
            }
        } while (!goodChoice);
        goodChoice = false;
    }

    static void editActivity(Patient patient) {
        do {
            typeActivity();
            if (scanner.hasNextInt()) {
                patient.setActivity(scanner.nextInt());
                scanner.nextLine();
                if (patient.getActivity() > 0 && patient.getActivity() <= 5) {
                    goodChoice = true;
                } else {
                    wrongChoice();
                }
            } else {
                scanner.nextLine();
                wrongChoice();
            }
        } while (!goodChoice);
        goodChoice = false;
    }

    static void editHeight(Patient patient) {
        do {
            System.out.println("Podaj wzrost pacjenta (w centymetrach):");
            if (scanner.hasNextInt()) {
                patient.setHeight(scanner.nextInt());
                scanner.nextLine();
                if (patient.getHeight() > 0 && patient.getHeight() < 300) {
                    goodChoice = true;
                } else {
                    wrongChoice();
                }
            } else {
                scanner.nextLine();
                wrongChoice();
            }
        } while (!goodChoice);
        goodChoice = false;
    }

    static void editWeight(Patient patient) {
        do {
            System.out.println("Podaj wagę pacjenta:");
            if (scanner.hasNextInt()) {
                patient.setWeight(scanner.nextInt());
                scanner.nextLine();
                if (patient.getWeight() > 0 && patient.getWeight() < 300) {
                    goodChoice = true;
                } else {
                    wrongChoice();
                }
            } else {
                scanner.nextLine();
                wrongChoice();
            }
        } while (!goodChoice);
        goodChoice = false;
    }

    static void editBornYear(Patient patient) {
        do {
            System.out.println("Podaj rok urodzenia pacjenta:");
            if (scanner.hasNextInt()) {
                patient.setYear(scanner.nextInt());
                scanner.nextLine();
                if (patient.getYear() > 1900 && patient.getYear() < 2100) {
                    goodChoice = true;
                } else {
                    wrongChoice();
                }
            } else {
                scanner.nextLine();
                wrongChoice();
            }
        } while (!goodChoice);
        goodChoice = false;
    }

    static void editGender(Patient patient) {
        do {
            System.out.println("Podaj płeć pacjenta (Mężczyzna - 1, Kobieta - 2)");
            if (scanner.hasNextInt()) {
                patient.setGender(scanner.nextInt());
                scanner.nextLine();
                if (patient.getGender() == 1 || patient.getGender() == 2) {
                    goodChoice = true;
                } else {
                    wrongChoice();
                }
            } else {
                scanner.nextLine();
                wrongChoice();
            }
        } while (!goodChoice);
        goodChoice = false;
    }
}
