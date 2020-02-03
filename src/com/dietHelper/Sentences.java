package com.dietHelper;

public class Sentences {
    public static void wrongChoice(){
        System.out.println("Wpisz poprawną wartość!");
    }
    public static void hello(){
        System.out.println("Witaj w programie DietHelper, który pomoże w ustaleniu Twojej diety!");
    }
    public static void mainMenu(){
        System.out.println(
                "1. Menu pacjenta \n" +
                "2. Menu lekarza  \n" +
                "3. Wyjście z programu \n" +
                "Wpisz numer: "); }
    public static void whatToDoDoctor(){
        System.out.println("Zarządzaj: \n" +
                "1. Listą pacjentów \n" +
                "2. Listą posiłków i produktów \n" +
                "3. Powrót do poprzedniego menu");
    }
    public static void patientAdmMenuSentence(){
        System.out.println("Wybierz co chcesz zrobić: \n" +
                "1. Dodaj pacjenta \n" +
                "2. Dodaj wyniki pacjenta \n" +
                "3. Przeglądaj listę pacjentów \n" +
                "4. Powrót do poprzedniego menu");
    }
    public static void dietAdmMenuSentence(){
        System.out.println("Wybierz co chcesz zrobić: \n" +
                "1. Dodaj produkt \n" +
                "2. Dodaj posiłek \n" +
                "3. Przeglądaj produkty \n" +
                "4. Przeglądaj posiłki \n" +
                "5. Ustal dietę \n" +
                "6. Powrót do poprzedniego menu");
    }
    public static void typeName(){
        System.out.println("Podaj imię pacjenta:");
    }
    public static void typeSurname(){
        System.out.println("Podaj nazwisko pacjenta:");
    }
    public static void typeGender(){
        System.out.println("Podaj płeć pacjenta (Mężczyzna - 1, Kobieta - 2)");
    }
    public static void typeAge(){
        System.out.println("Podaj wiek pacjenta:");
    }
    public static void typeWeight(){
        System.out.println("Podaj wagę pacjenta:");
    }
    public static void typeHeight(){
        System.out.println("Podaj wzrost pacjenta (w centymetrach):");
    }
    public static void typeActivity(){
        System.out.println("Podaj aktywność pacjenta: \n"+
                "1 - brak aktywności, praca siedząca \n" +
                "2 - niska aktywność, praca siedząca, 1-2 treningi w tygodniu \n" +
                "3 - średnia aktywność, praca siedząca, 3-4 treningi w tygodniu \n" +
                "4 - wysoka aktywność, praca fizyczna i 3-4 treningi w tygodniu \n" +
                "5 - bardzo wysoka aktywność, sportowcy zawodowi, osoby trenujące codzienie");
    }
    public static boolean isThatGoodChoice(int number, int lowRange, int highRange){
        if (number >= lowRange && number <= highRange){
            return true;
        }else{
            return false;
        }
    }
    public static void goodbye(){
        System.out.println("Do zobaczenia!");
    }
}
