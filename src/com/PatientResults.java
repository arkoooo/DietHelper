package com.DietHelper;

import java.util.LinkedList;
import java.util.List;

import static com.DietHelper.DoctorMenu.patientAdmMenu;
import static com.DietHelper.Sentences.*;
import static com.DietHelper.TypeOfResults.*;
import static com.DietHelper.Variables.*;

public class PatientResults {

    public static void resultMenu() {
        actualPatientSentence();
        UserInputs.getInputFromUser(patientResultsMenu(),1,5);


        switch(choice){
            case 1:
                Patient.writePatientList();
                UserInputs.getInputFromUser("Wpisz identyfikator pacjenta:", 0, patientList.size());
                selectedPatient = Variables.choice;
                choice = 0;
                resultMenu();
                break;
            case 2:
                Variables.numberOfResults++;
                Result glycemia = new Result(Variables.numberOfResults, Variables.selectedPatient, GLYCEMIA);
                Variables.resultsList.add(glycemia);
                UserInputs.getInputFromUser(glycemia,"Podaj glikemię na czczo:",0,500,"setFirstResult");
                UserInputs.getInputFromUser(glycemia,"Podaj glikemię 1h po przyjęciu glukozy",0,500,"setSecondResult");
                UserInputs.getInputFromUser(glycemia,"Podaj glikemię 2h po przyjęciu glukozy",0,500,"setThirdResult");
                choice = 0;
                resultMenu();
                break;
            case 3:
                Variables.numberOfResults++;
                Result insulin = new Result(Variables.numberOfResults, Variables.selectedPatient,INSULIN);
                Variables.resultsList.add(insulin);
                UserInputs.getInputFromUser(insulin,"Podaj insulinę na czczo:",0,500,"setFirstResult");
                UserInputs.getInputFromUser(insulin,"Podaj insulinę 1h po przyjęciu glukozy",0,500,"setSecondResult");
                UserInputs.getInputFromUser(insulin,"Podaj insulinę 2h po przyjęciu glukozy",0,500,"setThirdResult");
                choice = 0;
                resultMenu();
                break;
            case 4:
                findActualPatientResults();
                choice = 0;
                resultMenu();
                break;
            case 5:
                patientAdmMenu();
                break;
        }
    }
    public static void findActualPatientResults(){
        List<Result> actualPatientResultsList = new LinkedList<>();
        for (int i = 0; i < resultsList.size(); i++) {
            if(resultsList.get(i).getPatientId() == selectedPatient){
                actualPatientResultsList.add(resultsList.get(i));
            }
        }
        System.out.println("Wyniki:");
        if(actualPatientResultsList.size() == 0){
            System.out.println("Brak wyników");
        }else {
            for (int i = 0; i < actualPatientResultsList.size(); i++) {
                switch (actualPatientResultsList.get(i).getTypeOfResults()) {
                    case INSULIN:
                        System.out.println("Wyniki insuliny (id wyniku: " + actualPatientResultsList.get(i).getId() + ")");
                        System.out.println("Wynik na czczo: " + actualPatientResultsList.get(i).getFirstResult());
                        System.out.println("Wynik 1h po przyjęciu glukozy: " + actualPatientResultsList.get(i).getSecondResult());
                        System.out.println("Wynik 2h po przyjęciu glukozy: " + actualPatientResultsList.get(i).getThirdResult());
                        System.out.println();
                        break;
                    case GLYCEMIA:
                        System.out.println("Wyniki glikemii (id wyniku: " + actualPatientResultsList.get(i).getId() + ")");
                        System.out.println("Wynik na czczo: " + actualPatientResultsList.get(i).getFirstResult());
                        System.out.println("Wynik 1h po przyjęciu glukozy: " + actualPatientResultsList.get(i).getSecondResult());
                        System.out.println("Wynik 2h po przyjęciu glukozy: " + actualPatientResultsList.get(i).getThirdResult());
                        System.out.println();
                        break;
                    default:
                        System.out.println("Błąd");
                        break;
                }
            }
        }
    }

}
