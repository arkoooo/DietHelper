package com.dietHelper;

import java.util.Scanner;

import static com.dietHelper.Sentences.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static int choice;
    public static boolean goodChoice = false;
    public static boolean isThatInt = false;
    public static boolean isNeededGreetings = true;

    public static void main(String[] args) {
                mainMenu();
    }
        public static void mainMenu() {
            do{
                //The first time run of program greeting is displayed
                if(isNeededGreetings){
                    hello();
                    isNeededGreetings = false;
                }
                Sentences.mainMenu();
                if(scanner.hasNextInt()) { // If user type character then menu will be listed once again
                    choice = scanner.nextInt();
                    isThatInt = true;
                }else{
                    choice = 0; // If user go back from another menu, then choice will be defined and when user type ex. char, then choice will have old value, so there is reset.
                    wrongChoice();
                    isNeededGreetings = false; //Marking that greeting it's no longer needed
                }
                scanner.nextLine();
            }while(!isThatGoodChoice(choice,1,3)); //Menu will be displayed until user type correct input

            switch (choice){
                case 1:
                    PatientMenu.patientMenu();
                    //isThatInt = true;
                    break;
                case 2:
                    DoctorMenu.doctorFirstMenu();
                    //isThatInt = true;
                    break;
                case 3:
                    break;
            }
        }
    }

