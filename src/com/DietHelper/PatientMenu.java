package com.DietHelper;

import static com.DietHelper.Main.mainMenu;
import static com.DietHelper.TypeOfResults.GLYCEMIA;
import static com.DietHelper.TypeOfResults.INSULIN;
import static com.DietHelper.UserInputs.getInputFromUser;
import static com.DietHelper.Variables.*;

public class PatientMenu {

    public static void patientMenu() {
        Patient actualPatient = Variables.patientList.get(selectedPatient-1);
        getInputFromUser(Sentences.patientMenuSentence(), 1, 8);

        switch(choice){
            case 1:
                Diet.showDiet();
                choice = 0;
                patientMenu();
                break;
            case 2:
                Diet.showAllPatientMeals();
                choice = 0;
                patientMenu();;
            case 3:
                Variables.numberOfResults++;
                Result glycemia = new Result(Variables.numberOfResults, Variables.selectedPatient, GLYCEMIA);
                Variables.resultsList.add(glycemia);
                UserInputs.getInputFromUser(glycemia,"Podaj glikemię na czczo:",0,500,"setFirstResult");
                UserInputs.getInputFromUser(glycemia,"Podaj glikemię 1h po przyjęciu glukozy",0,500,"setSecondResult");
                UserInputs.getInputFromUser(glycemia,"Podaj glikemię 2h po przyjęciu glukozy",0,500,"setThirdResult");
                System.out.println("Podaj datę badania:");
                glycemia.setDate(scanner.nextLine());
                choice = 0;
                patientMenu();
                break;
            case 4:
                Variables.numberOfResults++;
                Result insulin = new Result(Variables.numberOfResults, Variables.selectedPatient,INSULIN);
                Variables.resultsList.add(insulin);
                UserInputs.getInputFromUser(insulin,"Podaj insulinę na czczo:",0,500,"setFirstResult");
                UserInputs.getInputFromUser(insulin,"Podaj insulinę 1h po przyjęciu glukozy",0,500,"setSecondResult");
                UserInputs.getInputFromUser(insulin,"Podaj insulinę 2h po przyjęciu glukozy",0,500,"setThirdResult");
                System.out.println("Podaj datę badania:");
                insulin.setDate(scanner.nextLine());
                choice = 0;
                patientMenu();
                break;
            case 5:
                PatientResults.findActualPatientResults();
                choice = 0;
                patientMenu();
                break;
            case 6:
                getInputFromUser("Podaj aktualną wagę: ", 10.0,400.0);
                System.out.println("Podaj datę ważenia: ");
                actualPatient.weightResults.put(weight,scanner.nextLine());
                choice = 0;
                patientMenu();
                break;
            case 7:
                for (Double i: actualPatient.weightResults.keySet()){
                    System.out.println("Data: "  + actualPatient.weightResults.get(i) + " waga: " + i);
                }
                choice = 0;
                patientMenu();
                break;
            case 8:
                choice = 0;
                mainMenu();
                break;
        }
    }

}
