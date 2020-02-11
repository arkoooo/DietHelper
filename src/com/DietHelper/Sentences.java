package com.DietHelper;

import static com.DietHelper.Variables.patientList;
import static com.DietHelper.Variables.selectedPatient;

public class Sentences {
    public static void wrongChoice(){
        System.out.println("Wpisz poprawną wartość!");
    }
    public static void hello(){
        System.out.println("Witaj w programie DietHelper, który pomoże w ustaleniu Twojej diety!");
    }
    public static String mainMenuSentence(){
        return
                "1. Menu pacjenta \n" +
                "2. Menu lekarza  \n" +
                "3. Wyjście z programu \n" +
                "Wpisz numer: "; }
    public static String whatToDoDoctor(){
        return "Zarządzaj: \n" +
                "1. Listą pacjentów \n" +
                "2. Listą posiłków i produktów \n" +
                "3. Powrót do poprzedniego menu\n" +
                "Wpisz numer: ";
    }
    public static String patientAdmMenuSentence(){
        return "Wybierz co chcesz zrobić: \n" +
                "1. Dodaj pacjenta \n" +
                "2. Przeglądaj i edytuj wyniki pacjenta \n" +
                "3. Przeglądaj i edytuj listę pacjentów \n" +
                "4. Powrót do poprzedniego menu \n" +
                "Wpisz numer: "; }
    public static String dietAdmMenuSentence(){
        return "Wybierz co chcesz zrobić: \n" +
                "1. Dodaj produkt \n" +
                "2. Dodaj posiłek \n" +
                "3. Przeglądaj produkty \n" +
                "4. Przeglądaj posiłki \n" +
                "5. Ustal dietę pacjentowi \n" +
                "6. Powrót do poprzedniego menu \n" +
                "Wpisz numer: ";}
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
    static String patientResultsMenu() {
        return "1. Wybierz pacjenta \n" +
                "2. Glukoza \n" +
                "3. Insulina \n" +
                "4. Wyświetl wyniki aktualnego pacjenta \n" +
                "5. Powrót do poprzedniego menu \n" +
                "Wpisz numer:";
    }
    static void actualPatientSentence() {
        System.out.println("Aktualnie wybrany pacjent: ID: " + patientList.get(Variables.selectedPatient-1).getId() + " Imię: " + patientList.get(Variables.selectedPatient-1).getName() + " Nazwisko: "
                + patientList.get(Variables.selectedPatient-1).getSurname());
    }

    static String whatDoYouWantToEdit() {
        return " Co chcesz edytować? \n" +
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
                "13. Informacje o alergii na gluten \n" +
                "14. Ponowne wyliczenie BMR oraz zapotrzebowania kalorycznego \n" +
                "15. Wyniki insuliny na czczo \n" +
                "16. Wyniki glukozy na czczo \n" +
                "17. Wróć do poprzedniego menu";
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
    public static String isPatientGlutenAllergicSentence(){
        return "Czy pacjent jest uczulony na gluten? ";
    }

    public static String changeIntToStatement(int choice){
        switch(choice){
            case 0:
                return "Nie.";
            case 1:
                return "Tak";
            case 2:
                return "Nie wiem.";
            default:
                return "Brak";
        }
    }
    public static int changeBooleanToInt(boolean choice){
        if(choice){
            return 1;
        }else{
            return 0;
        }
    }
    public static boolean changeIntToBoolean(int choice){
        if(choice == 1){
            return true;
        }else{
            return false;
        }
    }

    public static String changeActivity(int activity) {
        switch(activity){
            case 1:
                return "1 - brak aktywności, praca siedząca";

            case 2:
                return "2 - niska aktywność, praca siedząca, 1-2 treningi w tygodniu";

            case 3:
                return "3 - średnia aktywność, praca siedząca, 3-4 treningi w tygodniu";

            case 4:
                return "4 - wysoka aktywność, praca fizyczna i 3-4 treningi w tygodniu";

            case 5:
                return "5 - bardzo wysoka aktywność, sportowcy zawodowi, osoby trenujące codzienie";
            default:
                return null;
        }
    }
    public static String changeDiabeticProblem(int diabeticProblem){
        switch(diabeticProblem){
            case 1:
                return "Insulinooporność";

            case 2:
                return "Hiperinsulinemia";

            case 3:
                return "Hipoglikemia reaktywna";

            case 4:
                return "Cukrzyca";
            default:
                return null;
        }
    }

    public static void stringToMethod(Patient patient, String method, int choice){
        switch(method){
            case "setGender":
                patient.setGender(choice);
                break;
            case "setWeight":
                patient.setWeight(choice);
                break;
            case "setHeight":
                patient.setHeight(choice);
                break;
            case "setDiabetes":
                patient.setDiabetes(choice);
                break;
            case "setVegetarian":
                patient.setVegetarian(choice);
                break;
            case "setActivity":
                patient.setActivity(choice);
                break;
            case "setGlycemia":
                patient.setGlycemia(choice);
                break;
            case "setInsulin":
                patient.setInsulin(choice);
                break;
            case "setLactose":
                patient.setLactose(choice);
                break;
            case "setPeanuts":
                patient.setPeanuts(choice);
                break;
            case "setVegan":
                patient.setVegan(choice);
                break;
            case "setYear":
                patient.setYear(choice);
                break;
            case "setGluten":
                patient.setGluten(choice);
                break;
        }
    }

    public static void stringToMethod(Result result, String method, int choice){
            switch(method){
                case "setFirstResult":
                    result.setFirstResult(choice);
                    break;
                case "setSecondResult":
                    result.setSecondResult(choice);
                    break;
                case "setThirdResult":
                    result.setThirdResult(choice);
                    break;
            }
    }
    public static void stringToMethod(Product product, String method, int choice){
        switch(method){
            case "setProtein":
                product.setProtein(choice);
                break;
            case "setCarbohydrates":
                product.setCarbohydrates(choice);
                break;
            case "setFat":
                product.setFat(choice);
                break;
            case "setCalories":
                product.setCalories(choice);
                break;
            case "setForDiabetic":
                product.setForDiabetic(changeIntToBoolean(choice));
                break;
            case "setVegan":
                product.setVegan(changeIntToBoolean(choice));
                break;
            case "setVegetarian":
                product.setVegetarian(changeIntToBoolean(choice));
                break;
            case "hasLactose":
                product.setHasLactose(changeIntToBoolean(choice));
                break;
            case "hasPeanuts":
                product.setHasPeanuts(changeIntToBoolean(choice));
                break;
            case "hasGluten":
                product.setHasGluten(changeIntToBoolean(choice));
                break;
        }
    }
    public static String changeTypeOfMeal(TypeOfMeal typeOfMeal){
        switch(typeOfMeal){
            case ANY:
                return "dowolny.";
            case BREAKFAST:
                return "śniadanie.";
            case DINNER:
                return "obiad.";
            case SNACK:
                return "przekąska.";
            case SUPPER:
                return "kolacja.";
            default:
                return null;
        }
    }
    static void choiceToTypeOfMeal(Meal meal, int choice) {
        switch(choice){
            case 1:
                meal.setTypeOfMeal(TypeOfMeal.ANY);
                break;
            case 2:
                meal.setTypeOfMeal(TypeOfMeal.BREAKFAST);
                break;
            case 3:
                meal.setTypeOfMeal(TypeOfMeal.DINNER);
                break;
            case 4:
                meal.setTypeOfMeal(TypeOfMeal.SUPPER);
                break;
            case 5:
                meal.setTypeOfMeal(TypeOfMeal.SNACK);
                break;
            default:
                break;
        }
    }
}
