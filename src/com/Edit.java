package com.DietHelper;

import static com.DietHelper.UserInputs.getInputFromUser;
import static com.DietHelper.DoctorMenu.patientListMenu;
import static com.DietHelper.Variables.patientList;
import static com.DietHelper.Variables.selectedPatient;

public class Edit {
    public static void editPatient(){
        Patient actualPatient = patientList.get(selectedPatient-1);

        switch(Variables.choice){
            case 1:
                System.out.println("Aktualnie imię to: " +actualPatient.getName());
                System.out.println("Podaj imię pacjenta:");
                actualPatient.setName(Variables.scanner.nextLine());
                break;
            case 2:
                System.out.println("Aktualne nazwisko to: " +actualPatient.getSurname());
                System.out.println("Podaj nazwisko pacjenta:");
                actualPatient.setSurname(Variables.scanner.nextLine());
                break;
            case 3:
                System.out.println("Aktualny wiek to: " + actualPatient.getAge());
                getInputFromUser(actualPatient, Sentences.typeBornYear(), 1900,2100,"setYear");
                System.out.println("Uaktualniony wiek to: " + actualPatient.getAge());
                break;
            case 4:
                System.out.println("Aktualna waga to: " + actualPatient.getWeight());
                getInputFromUser(actualPatient, Sentences.typeWeight(), 1,300,"setWeight");
                System.out.println("Uaktualniona waga to: " + actualPatient.getWeight());

                break;
            case 5:
                System.out.println("Aktualna płeć to: " + actualPatient.changeGender());
                getInputFromUser(actualPatient, Sentences.typeGender(), 0,2,"setGender");
                System.out.println("Uaktualniona płeć to: " + actualPatient.changeGender());
                break;
            case 6:
                System.out.println("Aktualny wzrost to: " + actualPatient.getHeight());
                getInputFromUser(actualPatient, Sentences.typeHeight(), 1,250,"setHeight");
                System.out.println("Uaktualniony wzrost to: " + actualPatient.getHeight());
                break;
            case 7:
                System.out.println("Aktualna aktywność to: " + Sentences.changeActivity(actualPatient.getActivity()));
                getInputFromUser(actualPatient, Sentences.typeActivity(), 1,5,"setActivity");
                System.out.println("Uaktualniona aktywność to: " + Sentences.changeActivity(actualPatient.getActivity()));
                break;
            case 8:
                System.out.println("Aktualny wybrany problem gospodarki insulinowej to: " + Sentences.changeDiabeticProblem(actualPatient.getDiabetes()));
                getInputFromUser(actualPatient, Sentences.chooseDiabeticProblem(), 0,5,"setDiabetes");
                System.out.println("Uaktualniony problem gospodarki insulinowej to: " + Sentences.changeDiabeticProblem(actualPatient.getDiabetes()));
                break;
            case 9:
                System.out.println("Aktualna informacja dotycząca alergii na orzechy to: " + Sentences.changeIntToStatement(actualPatient.getPeanuts()));
                getInputFromUser(actualPatient, Sentences.isPatientNutsAllergicSentence(), 0,2,"setPeanuts");
                System.out.println("Uaktualniona informacja dotycząca alergii na orzechy to: " + Sentences.changeIntToStatement(actualPatient.getPeanuts()));
                break;
            case 10:
                System.out.println("Aktualna informacja dotycząca alergii na laktozę to: " + Sentences.changeIntToStatement(actualPatient.getLactose()));
                getInputFromUser(actualPatient, Sentences.isPatientLactoseIntolerantSentence(), 0,2,"setLactose");
                System.out.println("Uaktualniona informacja dotycząca alergii na laktozę to: " + Sentences.changeIntToStatement(actualPatient.getLactose()));
                break;
            case 11:
                System.out.println("Aktualna informacja dotycząca weganizmu to: " + Sentences.changeIntToStatement(actualPatient.getVegan()));
                getInputFromUser(actualPatient, Sentences.isPatientVeganSentence(), 0,2,"setVegan");
                System.out.println("Uaktualniona informacja dotycząca weganizmu to: " + Sentences.changeIntToStatement(actualPatient.getVegan()));
                break;
            case 12:
                System.out.println("Aktualna informacja dotycząca wegetarianizmu to: " + Sentences.changeIntToStatement(actualPatient.getVegetarian()));
                getInputFromUser(actualPatient, Sentences.isPatientVegetarianSentence(), 0,2,"setVegetarian");
                System.out.println("Uaktualniona informacja dotycząca wegetarianizmu to: " + Sentences.changeIntToStatement(actualPatient.getVegetarian()));
                break;
            case 13:
                System.out.println("Aktualna informacja dotycząca alergii na gluten to: " + Sentences.changeIntToStatement(actualPatient.getGluten()));
                getInputFromUser(actualPatient, Sentences.isPatientGlutenAllergicSentence(), 0,2,"setGluten");
                System.out.println("Uaktualniona informacja dotycząca alergii na gluten to: " + Sentences.changeIntToStatement(actualPatient.getGluten()));
                break;
            case 14:
                System.out.println("Aktualny BMR to: " + actualPatient.getBmr() + "\n" +
                        "aktualne zapotrzebowanie kaloryczne to: " + actualPatient.getCalories() + " kcal");
                actualPatient.calculateBmr();
                actualPatient.calculateTotalMetabolism();
                System.out.println("Nowy BMR to: " + actualPatient.getBmr() + "\n" +
                        "uaktualnione zapotrzebowanie kaloryczne to: " + actualPatient.getCalories() + " kcal");
                break;
            case 15:
                System.out.println("Aktualny wynik insuliny to: " + actualPatient.getInsulin());
                getInputFromUser(actualPatient, Sentences.typeInsulin(), 0,2,"setInsulin");
                System.out.println("Uaktualniony wynik insuliny to: " + actualPatient.getInsulin());
                break;
            case 16:
                System.out.println("Aktualna wynik glikemii to: " + actualPatient.getGlycemia());
                getInputFromUser(actualPatient, Sentences.typeGlycemia(), 0,2,"setGlycemia");
                System.out.println("Uaktualniony wynik glikemii to: " + actualPatient.getGlycemia());
                break;
            case 17:
                patientListMenu();
                break;
        }
    }
}
