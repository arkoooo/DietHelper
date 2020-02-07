package com.dietHelper;

import static com.dietHelper.Add.patientList;

public class Sentences {
    public static void wrongChoice(){
        System.out.println("Wpisz poprawną wartość!");
    }
    public static void hello(){
        System.out.println("Witaj w programie DietHelper, który pomoże w ustaleniu Twojej diety!");
    }
    public static void mainMenuSentence(){
        System.out.println(
                "1. Menu pacjenta \n" +
                "2. Menu lekarza  \n" +
                "3. Wyjście z programu \n" +
                "Wpisz numer: "); }
    public static void whatToDoDoctor(){
        System.out.println("Zarządzaj: \n" +
                "1. Listą pacjentów \n" +
                "2. Listą posiłków i produktów \n" +
                "3. Powrót do poprzedniego menu\n" +
                "Wpisz numer: ");
    }
    public static void patientAdmMenuSentence(){
        System.out.println("Wybierz co chcesz zrobić: \n" +
                "1. Dodaj pacjenta \n" +
                "2. Dodaj wyniki pacjenta \n" +
                "3. Przeglądaj i edytuj listę pacjentów \n" +
                "4. Powrót do poprzedniego menu \n" +
                "Wpisz numer: "); }
    public static void dietAdmMenuSentence(){
        System.out.println("Wybierz co chcesz zrobić: \n" +
                "1. Dodaj produkt \n" +
                "2. Dodaj posiłek \n" +
                "3. Przeglądaj produkty \n" +
                "4. Przeglądaj posiłki \n" +
                "5. Ustal dietę pacjentowi \n" +
                "6. Powrót do poprzedniego menu \n" +
                "Wpisz numer: "); }
    public static String typeActivity(){
        return "Podaj aktywność pacjenta: \n"+
                "1 - brak aktywności, praca siedząca \n" +
                "2 - niska aktywność, praca siedząca, 1-2 treningi w tygodniu \n" +
                "3 - średnia aktywność, praca siedząca, 3-4 treningi w tygodniu \n" +
                "4 - wysoka aktywność, praca fizyczna i 3-4 treningi w tygodniu \n" +
                "5 - bardzo wysoka aktywność, sportowcy zawodowi, osoby trenujące codzienie";
    }
    public static boolean isThatGoodChoice(int number, int lowRange, int highRange){
        if (number >= lowRange && number <= highRange){
            return true;
        }else{
            return false;
        }
    }
    static void patientResultsMenu() {
        System.out.println("Wpisz wynik pacjenta: \n" +
                "1. Wybierz pacjenta \n" +
                "2. Glukoza \n" +
                "3. Insulina \n" +
                "4. Powrót do poprzedniego menu \n" +
                "Wpisz numer:");
    }
    static void actualPatientSentence() {
        System.out.println("Aktualnie wybrany pacjent: ID: " + patientList.get(PatientResults.selectedPatient-1).getId() + ". Imię: " + patientList.get(PatientResults.selectedPatient-1).getName() + " Nazwisko: "
                + patientList.get(PatientResults.selectedPatient-1).getSurname());
    }

    static void whatDoYouWantToEdit() {
        System.out.println("Co chcesz edytować?" +
                "1. Imię pacjenta \n" +
                "2. Nazwisko pacjenta \n" +
                "3. Rok urodzenia pacjenta \n" +
                "4. Wagę pacjenta \n" +
                "5. Płeć pacjenta \n" +
                "6. Wzrost pacjenta \n" +
                "7. Aktywność pacjenta \n" +
                "8. Informację o zaburzeniach gospodarki insulinowej \n" +
                "9. Informację o uczuleniu na orzechy \n" +
                "10. Informację o uczuleniu na laktozę \n" +
                "11. Informację o weganiźmie \n" +
                "12. Informację o wegetarianiźmie \n" +
                "13. Ponowne wyliczenie BMR oraz zapotrzebowania kalorycznego \n" +
                "14. Wyniki insuliny na czczo \n" +
                "15. Wyniki glukozy na czczo \n" +
                "16. Wróć do poprzedniego menu\n");
    }

    static String isPatientNutsAllergicSentence() {
        return "Czy pacjent ma nietolerancję na orzechy?";
    }

    public static String isPatientVegetarianSentence(){
        return "Czy pacjent jest wegetarianinem?";
    }

    static String isPatientVeganSentence() {
        return "Czy pacjent jest weganem?";
    }

    public static String typeInsulin(){
        return "Podaj wynik insuliny na czczo: [mU/ml]";
    }

    public static String typeGlycemia(){
        return "Podaj wynik glikemii na czczo [mmol/l]:";
    }

    public static String chooseDiabeticProblem(){
        return "Czy ma stwierdzoną insulinooporność(1)/hiperinsulinemię(2)/hipoglikemię " +
                "reaktywną(3)/cukrzycę(4)? Wpisz odpowiednią cyfrę jeżeli tak, 0 jeżeli brak.";
    }

    public static String isPatientLactoseIntolerantSentence(){
        return "Czy ma nietolerancję laktozy?";
    }

    public static String typeHeight(){
        return "Podaj wzrost pacjenta (w centymetrach):";
    }

    public static String typeWeight(){
        return "Podaj wagę pacjenta:";
    }

    public static String typeBornYear(){
        return "Podaj rok urodzenia pacjenta:";
    }

    public static String typeGender(){
        return "Podaj płeć pacjenta (Mężczyzna - 1, Kobieta - 2)";
    }
}
