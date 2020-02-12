package com.DietHelper;

import static com.DietHelper.Sentences.*;
import static com.DietHelper.Variables.choice;

public class UserInputs {
    public static int getInputFromUser(String sentence, int lowRange, int highRange){
        do {
            System.out.println(sentence);
            if (Variables.scanner.hasNextInt()) {
                Variables.choice = Variables.scanner.nextInt();
                Variables.scanner.nextLine();
                if (isThatGoodChoice(Variables.choice, lowRange, highRange)) {
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
        return choice;
    }

    public static void getInputFromUser(Patient patient, String sentence, int lowRange, int highRange, String stringToMethod){
        do {
            System.out.println(sentence);
            if (Variables.scanner.hasNextInt()) {
                Variables.choice = Variables.scanner.nextInt();
                Variables.scanner.nextLine();
                if (isThatGoodChoice(Variables.choice, lowRange, highRange)) {
                    stringToMethod(patient, stringToMethod, Variables.choice);
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

    public static void getInputFromUser(Result result, String sentence, int lowRange, int highRange, String stringToMethod){
        do {
            System.out.println(sentence);
            if (Variables.scanner.hasNextInt()) {
                Variables.choice = Variables.scanner.nextInt();
                Variables.scanner.nextLine();
                if (isThatGoodChoice(Variables.choice, lowRange, highRange)) {
                    stringToMethod(result, stringToMethod, Variables.choice);
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

    public static void getInputFromUser(Product product, String sentence, int lowRange, int highRange, String stringToMethod){
        do {
            System.out.println(sentence);
            if (Variables.scanner.hasNextInt()) {
                Variables.choice = Variables.scanner.nextInt();
                Variables.scanner.nextLine();
                if (isThatGoodChoice(Variables.choice, lowRange, highRange)) {
                    stringToMethod(product, stringToMethod, Variables.choice);
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
    public static int getInputFromUser(Meal meal, String sentence, int lowRange, int highRange){
        do {
            System.out.println(sentence);
            if (Variables.scanner.hasNextInt()) {
                Variables.choice = Variables.scanner.nextInt();
                Variables.scanner.nextLine();
                if (isThatGoodChoice(Variables.choice, lowRange, highRange)) {
                    choiceToTypeOfMeal(meal, Variables.choice);
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
        return choice;
    }

}
