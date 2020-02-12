package com.DietHelper;
import static com.DietHelper.UserInputs.getInputFromUser;
import static com.DietHelper.Edit.editPatient;
import static com.DietHelper.PatientResults.resultMenu;
import static com.DietHelper.Sentences.*;
import static com.DietHelper.Variables.*;

public class DoctorMenu {
    public static void doctorFirstMenu(){
        getInputFromUser(whatToDoDoctor(),1,3);

        switch(Variables.choice){
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
            getInputFromUser(patientAdmMenuSentence(),1,4);

            switch(Variables.choice){
                case 1:
                    Add.newPatient();
                    break;
                case 2:
                    resultMenu();
                    break;
                case 3:
                    patientListMenu();
                    break;
                case 4:
                    doctorFirstMenu();
                    break;
                default:
                    break;
            }
    }

    public static void patientListMenu() {
        Patient.writePatientList();
        getInputFromUser("1. Wybierz pacjenta \n" +
                "2. Edytuj aktualnie wybranego pacjenta \n" +
                "3. Powrót do poprzedniego menu \n" +
                "Wpisz numer, aby wybrać:",1,3);

            switch (Variables.choice) {
                case 1:
                    getInputFromUser("Wpisz identyfikator pacjenta:", 0, patientList.size());
                    selectedPatient = Variables.choice;
                    actualPatientSentence();
                    patientListMenu();
                    break;
                case 2:
                    actualPatientSentence();
                    getInputFromUser(whatDoYouWantToEdit(),1,17);
                    editPatient();
                    patientListMenu();
                    break;
                case 3:
                    patientAdmMenu();
                    break;
            }
    }

    private static void dietAdmMenu() {
        getInputFromUser(dietAdmMenuSentence(),1,8);
        switch(choice){
            case 1:
                Add.newProduct();
                choice = 0;
                dietAdmMenu();
                break;
            case 2:
                Add.newMeal();
                choice = 0;
                dietAdmMenu();
                break;
            case 3:
                Product.listOfProducts();
                choice = 0;
                dietAdmMenu();
                break;
            case 4:
                Meal.listOfMeals();
                choice = 0;
                dietAdmMenu();
                break;
            case 5:
                Diet.createDiet();
                choice = 0;
                dietAdmMenu();
                break;
            case 6:
                Product.listOfProducts();
                getInputFromUser("Podaj identyfikator produktu, który usunąć",0,productsList.size());
                if(choice==0){
                    break;
                }
                productsList.remove(choice-1);
                choice =0;
                dietAdmMenu();
                break;
            case 7:
                Meal.listOfMeals();
                getInputFromUser("Podaj identyfikator posiłku, który usunąć",0,mealsList.size());
                if(choice==0){
                    break;
                }
                mealsList.remove(choice-1);
                choice = 0;
                dietAdmMenu();
                break;
            case 8:
                doctorFirstMenu();
                break;
        }
    }
}
