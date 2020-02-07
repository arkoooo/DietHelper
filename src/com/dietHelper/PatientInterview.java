package com.dietHelper;

import static com.dietHelper.Main.goodChoice;
import static com.dietHelper.Main.scanner;
import static com.dietHelper.Sentences.isThatGoodChoice;
import static com.dietHelper.Sentences.wrongChoice;

public class PatientInterview {
    public static void isPatientNutsAllergic(Patient patient) {
        do {
            System.out.println("Czy pacjent ma nietolerancję na orzechy?");
            if (scanner.hasNextInt()) {
                patient.setPeanuts(scanner.nextInt());
                scanner.nextLine();
                if (isThatGoodChoice(patient.getPeanuts(), 0, 2)) {
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
