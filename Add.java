package com.dietHelper;

import java.util.LinkedList;
import java.util.List;

import static com.dietHelper.Main.*;
import static com.dietHelper.Patient.stringToMethod;
import static com.dietHelper.Sentences.isThatGoodChoice;
import static com.dietHelper.Sentences.wrongChoice;

public class Add {
    public static int numberOfPatients = 0;
    static List<Patient> patientList = new LinkedList<>();

    public static void newPatient() {
        Patient patient = new Patient();
        patientList.add(patient);
        numberOfPatients++;
        PatientResults.selectedPatient = numberOfPatients; //After creating new patient, this will be the currently selected one.
        patient.setId(numberOfPatients);

        System.out.println("Podaj imię pacjenta:");
        patient.setName(scanner.nextLine());
        System.out.println("Podaj nazwisko pacjenta:");
        patient.setSurname(scanner.nextLine());

        getInputFromUser(patient, Sentences.typeGender(), 0,2,"setGender");
        getInputFromUser(patient, Sentences.typeBornYear(), 1900,2100,"setYear");
        getInputFromUser(patient, Sentences.typeWeight(), 1,300,"setWeight");
        getInputFromUser(patient, Sentences.typeHeight(), 1,250,"setHeight");
        getInputFromUser(patient, Sentences.typeActivity(), 1,5,"set");

        // Calculate BMR and calories intake by methods
        patient.calculateBmr();
        patient.calculateTotalMetabolism();

        //Display patient data
        System.out.println("Utworzono nowego pacjenta: " + patient.getName() + " " + patient.getSurname() + "\n" +
                "Płeć: " + patient.changeGender() + "\n" +
                "Wiek: " + patient.getAge() + "\n" +
                "Waga: " + patient.getWeight() + "\n" +
                "Wzrost: " + patient.getHeight() + "\n" +
                "Aktywność: " + patient.getActivity() + "\n" +
                "Wyliczony BMR: " + patient.getBmr() + " kcal" + "\n" +
                "Zapotrzebowanie kaloryczne: " + patient.getCalories() + " kcal"
        );

        System.out.println("Przeprowadź wywiad z pacjentem. \n" +
                "Jeżeli pacjent odpowie tak: wpisz 1, jeżeli nie: wpisz 0, jeżeli nie znasz odpowiedzi wpisz: 2");
        getInputFromUser(patient, Sentences.isPatientNutsAllergicSentence(), 0,2,"setPeanuts");
        getInputFromUser(patient, Sentences.isPatientLactoseIntolerantSentence(), 0,2,"setLactose");
        getInputFromUser(patient, Sentences.chooseDiabeticProblem(), 1,5,"setDiabetes");

        if (patient.getDiabetes() > 0) {
            System.out.println("Jeżeli pacjent ma stwierdzone problemy z gospodarką insulinową, konieczne jest wypełnienie wywiadu pacjenta " +
                    "w którym zawarte będą dokładne wyniki glukozy oraz insuliny we krwi po obciążeniu glukozą");
        }

        //The result of insulin and glucose will be taken only if the problems are not officially identified and if user declare that he has results.
        // Otherwise, the doctor fills results in the patient's results

        getInputFromUser(patient, Sentences.typeGlycemia(), 0,2,"setGlycemia");
        getInputFromUser(patient, Sentences.typeInsulin(), 0,2,"setInsulin");
        getInputFromUser(patient, Sentences.isPatientVeganSentence(), 0,2,"setVegan");
        getInputFromUser(patient, Sentences.isPatientVegetarianSentence(), 0,2,"setVegetarian");


    if(patient.getDiabetes() == 0) {
        patient.homaIR();
        patient.checkHomaIR();
    }
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

    public static void getInputFromUser(Patient patient, String sentence, int lowRange, int highRange, String stringToMethod){
        do {
            System.out.println(sentence);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (isThatGoodChoice(choice, lowRange, highRange)) {
                    stringToMethod(patient, stringToMethod);
                    goodChoice = true;
                } else {
                    wrongChoice();
                    goodChoice = false;
                }
            } else {
                scanner.nextLine();
                goodChoice = false;
                wrongChoice();
            }
        } while (!goodChoice);
    }

    public static void newMeal() {
        Meal meal = new Meal();
    }
    public static void newProduct(){
        Product product = new Product();
    }


}
