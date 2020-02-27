package com.DietHelper;

import static com.DietHelper.Product.listOfProducts;
import static com.DietHelper.UserInputs.isThatGoodChoice;
import static com.DietHelper.Sentences.wrongChoice;
import static com.DietHelper.UserInputs.getInputFromUser;
import static com.DietHelper.Variables.*;

public class Add {
    public static void newPatient() {
        Patient patient = new Patient();
        Variables.patientList.add(patient);
        Variables.numberOfPatients++;
        Variables.selectedPatient = Variables.numberOfPatients; //After creating new patient, this will be the currently selected one.
        patient.setId(Variables.numberOfPatients);

        System.out.println("Podaj imię pacjenta:");
        patient.setName(Variables.scanner.nextLine());
        System.out.println("Podaj nazwisko pacjenta:");
        patient.setSurname(Variables.scanner.nextLine());

        getInputFromUser(patient, Sentences.typeGender(), 0,2,"setGender");
        getInputFromUser(patient, Sentences.typeBornYear(), 1900,2100,"setYear");
        getInputFromUser(patient, Sentences.typeWeight(), 1,300,"setWeight");
        getInputFromUser(patient, Sentences.typeHeight(), 1,250,"setHeight");
        getInputFromUser(patient, Sentences.typeActivity(), 1,5,"setActivity");

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
                "Zapotrzebowanie kaloryczne: " + patient.getCalories() + " kcal");
        System.out.println("Przeprowadź wywiad z pacjentem. \n" +
                "Jeżeli pacjent odpowie tak: wpisz 1, jeżeli nie: wpisz 0, jeżeli nie znasz odpowiedzi wpisz: 2");
        getInputFromUser(patient, Sentences.isPatientNutsAllergicSentence(), 0,2,"setPeanuts");
        getInputFromUser(patient, Sentences.isPatientLactoseIntolerantSentence(), 0,2,"setLactose");
        getInputFromUser(patient, Sentences.chooseDiabeticProblem(), 0,5,"setDiabetes");

        //Patient interview reminder displayed only when the patient has sugar problems
        if (patient.getDiabetes() > 0) {
            System.out.println("Jeżeli pacjent ma stwierdzone problemy z gospodarką insulinową, konieczne jest wypełnienie wywiadu pacjenta " +
                    "w którym zawarte będą dokładne wyniki glukozy oraz insuliny we krwi po obciążeniu glukozą");
        }

        //The result of insulin and glucose will be taken only if the problems are not officially identified and if user declare that he has results.
        // Otherwise, the doctor fills results in the patient's results

        getInputFromUser(patient, Sentences.typeGlycemia(), 0,500,"setGlycemia");
        getInputFromUser(patient, Sentences.typeInsulin(), 0,500,"setInsulin");
        getInputFromUser(patient, Sentences.isPatientVeganSentence(), 0,2,"setVegan");
        getInputFromUser(patient, Sentences.isPatientVegetarianSentence(), 0,2,"setVegetarian");
        getInputFromUser(patient, Sentences.isPatientGlutenAllergicSentence(), 0 ,2, "setGluten");

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
        DoctorMenu.doctorFirstMenu();
    }
    public static void newProduct(){
        Product product = new Product();
        numberOfProducts++;
        Variables.productsList.add(product);

        System.out.println("Podaj nazwę dodawanego produktu: ");
        product.setName(scanner.nextLine());

        getInputFromUser(product,"Podaj liczbę białka na 100g: ",0,100,"setProtein");
        getInputFromUser(product,"Podaj liczbę węglowodanów na 100g: ",0,100,"setCarbohydrates");
        getInputFromUser(product,"Podaj liczbę tłuszczu na 100g: ",0,100,"setFat");
        getInputFromUser(product,"Podaj liczbę kalorii na 100g: ",0,900,"setCalories");
        getInputFromUser(product, "Czy produkt jest wegański? Jeżeli tak, wpisz 1. Jeżeli nie, wpisz 0.",0,1,"setVegan");
        // When product is vegan, automatically it is vegetarian
        if(product.isVegan()){
            product.setVegetarian(true);
        }
        // If product is not for vegan, then display question about vegetarian
        if(!product.isVegan()) {
            getInputFromUser(product, "Czy produkt jest wegetariański? Jeżeli tak, wpisz 1. Jeżeli nie, wpisz 0.", 0, 1, "setVegetarian");
        }
        getInputFromUser(product, "Czy produkt ma laktozę? Jeżeli tak, wpisz 1. Jeżeli nie, wpisz 0.",0,1,"hasLactose");
        getInputFromUser(product, "Czy produkt może mieć w składzie orzechy? Jeżeli tak, wpisz 1. Jeżeli nie, wpisz 0.",0,1,"hasPeanuts");
        getInputFromUser(product, "Czy produkt ma w składzie gluten? Jeżeli tak, wpisz 1. Jeżeli nie, wpisz 0.",0,1,"hasGluten");

        // Displaying product data
        System.out.println("Utworzono nowy produkt: " + product.getName()+ "\n" +
                "Ilość białka: " + product.getProtein() + "\n" +
                "Ilość węglowodanów: " + product.getCarbohydrates()+ "\n" +
                "Ilość tłuszczu: " + product.getFat() + "\n" +
                "Ilość kalorii: " + product.getCalories()
        );
        if(product.isVegan()){
            System.out.println("Produkt jest wegański.");
        }if(!product.isVegan()){
            System.out.println("Produkt nie jest wegański.");
        }if(product.isVegetarian() && !product.isVegan()){
            System.out.println("Produkt jest wegetariański.");
        }if(!product.isVegetarian()){
            System.out.println("Produkt nie jest wegetariański.");
        }if(product.isHasLactose()){
            System.out.println("Produkt posiada w składzie laktozę.");
        }if(!product.isHasLactose()){
            System.out.println("Produkt nie posiada w składzie laktozy.");
        }if(product.isHasPeanuts()){
            System.out.println("Produkt posiada w składzie orzeszki.");
        }if(!product.isHasPeanuts()){
            System.out.println("Produkt nie posiada w składzie orzeszków");
        }
    }
    public static void newMeal() {
        Meal meal = new Meal();

        System.out.println("Podaj nazwę posiłku: ");
        meal.setName(scanner.nextLine());
        System.out.println("Dodaj poszczególne produkty, z których składa się posiłek. Po kolei wpisuj identyfikator produktu oraz gramaturę.");
        getInputFromUser(meal, "Jakiego typu to posiłek? Wybierz 1: jeżeli dowolny, 2: jeżeli śniadanie, 3: jeżeli obiad, 4: jeżeli kolacja, 5: jeżeli przekąska",1,5);
        int sizeOfMeal = getInputFromUser("Jeżeli chcesz dodać jeden posiłek w 3 wariantach (mały, średni, duży), wpisz 0. Jeżeli chcesz dodać 1 wariant to wpisz odpowiednio 1 dla małego, 2 dla średniego, 3 dla dużego",0,3);
        tempNumberOfProducts = getInputFromUser("Z ilu produktów składa się posiłek?",1,30);
        listOfProducts(); // displaying all products

        switch(sizeOfMeal){
            case 1:
                meal.setSizeOfMeal(SizeOfMeal.SMALL);
                break;
            case 2:
                meal.setSizeOfMeal(SizeOfMeal.MEDIUM);
                break;
            case 3:
                meal.setSizeOfMeal(SizeOfMeal.LARGE);
                break;
        }
        addProductsToMeal(meal);
        meal.calculateMeal();
        mealsList.add(meal);
    }
    public static void addProductsToMeal(Meal meal) {
        for (int i = 0; i < tempNumberOfProducts; i++) {
            // Loop do while like try catch
            do {
                // Providing product identifier
                System.out.println("Podaj identyfikator produktu: ");
                if (Variables.scanner.hasNextInt()) {
                    Variables.choice = Variables.scanner.nextInt();
                    Variables.scanner.nextLine();
                    if (isThatGoodChoice(Variables.choice, 1, productsList.size())) {
                        meal.listOfProductsInMeal.add(productsList.get(choice - 1));
                        Variables.goodChoice = true;
                    } else {
                        wrongChoice();
                        Variables.goodChoice = false;
                    }
                } else {
                    Variables.scanner.nextLine();
                    Variables.goodChoice = false;
                    wrongChoice();
                }
            } while (!Variables.goodChoice);
            do {
                // Providing weight of product
                System.out.println("Podaj wagę produktu: ");
                if (Variables.scanner.hasNextInt()) {
                    Variables.choice = Variables.scanner.nextInt();
                    Variables.scanner.nextLine();
                    if (isThatGoodChoice(Variables.choice, 0, 10000)) {
                        meal.weightOfProducts.add(choice);
                        Variables.goodChoice = true;
                    } else {
                        wrongChoice();
                        Variables.goodChoice = false;
                    }
                } else {
                    Variables.scanner.nextLine();
                    Variables.goodChoice = false;
                    wrongChoice();
                }
            } while (!Variables.goodChoice);
        }
    }
}
