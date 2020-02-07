package com.dietHelper;
import static com.dietHelper.Add.patientList;
import static com.dietHelper.Edit.editPatient;
import static com.dietHelper.Main.*;
import static com.dietHelper.PatientResults.resultMenu;
import static com.dietHelper.PatientResults.selectedPatient;
import static com.dietHelper.Sentences.*;

public class DoctorMenu {
    public static void doctorFirstMenu(){

        //Menu will be displayed until user type correct input
        do{
            whatToDoDoctor();
            if(scanner.hasNextInt()) { // If user type character then menu will be listed once again
                choice = scanner.nextInt();
            }else{
                choice = 0;
                wrongChoice();
            }
            scanner.nextLine();
        }while(!isThatGoodChoice(choice,1,3));

        switch(choice){
            case 1:
                patientAdmMenu();
                break;
            case 2:
                dietAdmMenu();
                break;
            case 3:
                Main.mainMenu();
                break;
            default:
                wrongChoice();
                break;
        }
    }
    public static void patientAdmMenu() {
        do {
            patientAdmMenuSentence();
            if(scanner.hasNextInt()) { // If user type character then menu will be listed once again
                choice = scanner.nextInt();
            }else{
                choice = 0;
                wrongChoice();
            }
            scanner.nextLine();
            switch(choice){
                case 1:
                    Add.newPatient();
                    break;
                case 2:
                    resultMenu();
                    break;
                case 3:
                    patientListMenu();

                case 4:
                    doctorFirstMenu();
                    break;
                default:
                    break;
            }
        } while(!isThatGoodChoice(choice,1,4));
    }

    private static void patientListMenu() {
        for (int i = 0; i < patientList.size(); i++) {
            System.out.print(patientList.get(i).getId() + " " + patientList.get(i).getName() + " " + patientList.get(i).getSurname());
            if (i == selectedPatient - 1) {
                System.out.print(" <- Aktualnie wybrany pacjent. \n");
            }else{
                System.out.println("");
            }
        }
        System.out.println("");
        do {
            System.out.println("1. Wybierz pacjenta \n" +
                    "2. Edytuj aktualnie wybranego pacjenta \n" +
                    "3. Powrót do poprzedniego menu \n" +
                    "Wpisz numer, aby wybrać:");
            if (scanner.hasNextInt()) { // If user type character then menu will be listed once again
                choice = scanner.nextInt();
            } else {
                goodChoice = false;
                wrongChoice();
            }
        }while(!isThatGoodChoice(choice,1,3) && !goodChoice);
            scanner.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Wpisz identyfikator pacjenta:");
                        if (scanner.hasNextInt()) { // If user type character then menu will be listed once again
                            choice = scanner.nextInt();
                        } else {
                            wrongChoice();
                        }
                    }while(!isThatGoodChoice(choice,0,patientList.size()-1));
                    selectedPatient = choice-1;
                    actualPatientSentence();
                    break;
                case 2:
                    actualPatientSentence();
                    do {
                        whatDoYouWantToEdit();
                        if (scanner.hasNextInt()) { // If user type character then menu will be listed once again
                            choice = scanner.nextInt();
                        } else {
                            wrongChoice();
                        }
                    }while(!isThatGoodChoice(choice,1,16));
                    editPatient();
                    break;
                case 3:
                    patientAdmMenu();
                    break;
            }
    }

    private static void dietAdmMenu() {
        do {
            dietAdmMenuSentence();
            choice = scanner.nextInt();
            scanner.nextLine();
        } while(!isThatGoodChoice(choice,1,6));
    }
}
