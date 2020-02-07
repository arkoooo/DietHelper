package com.dietHelper;

import java.util.LinkedList;
import java.util.List;

import static com.dietHelper.Main.*;
import static com.dietHelper.PatientInterview.isPatientNutsAllergic;

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

        Edit.editGender(patient);
        Edit.editBornYear(patient);
        Edit.editWeight(patient);
        Edit.editHeight(patient);
        Edit.editActivity(patient);

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
       isPatientNutsAllergic(patient);
       Edit.isPatientLactoseIntolerant(patient);
       Edit.hasPatientDiabeticProblems(patient);

        if (patient.getDiabetes() > 0) {
            System.out.println("Jeżeli pacjent ma stwierdzone problemy z gospodarką insulinową, konieczne jest wypełnienie wywiadu pacjenta " +
                    "w którym zawarte będą dokładne wyniki glukozy oraz insuliny we krwi po obciążeniu glukozą");
        }

        //The result of insulin and glucose will be taken only if the problems are not officially identified and if user declare that he has results.
        // Otherwise, the doctor fills results in the patient's results

        Edit.editGlycemiaAndInsulin(patient);
        Edit.isPatientVegan(patient);
        Edit.isPatientVegetarian(patient);

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


    public static void newMeal() {
        Meal meal = new Meal();
    }
    public static void newProduct(){
        Product product = new Product();
    }
}
