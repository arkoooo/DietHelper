package com.dietHelper;

import java.util.Scanner;

import static com.dietHelper.Sentences.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static int choice;
    public static boolean isThatInt = false;
    public static boolean isNeededGreetings = true;

    public static void main(String[] args) {
            do{
                mainMenu();
            } while(!isThatInt);
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
                    wrongChoice();
                    choice = 0;
                    isNeededGreetings = false; //Marking that greeting it's no longer needed
                }
                scanner.nextLine();
            }while(!isThatGoodChoice(choice,1,3) && isThatInt); //Menu will be displayed until user type correct input

            switch (choice){
                case 1:
                    PatientMenu.patientMenu();
                    isThatInt = true;
                    choice = 0;
                    break;
                case 2:
                    DoctorMenu.doctorFirstMenu();
                    isThatInt = true;
                    choice = 0;
                    break;
                case 3:
                    break;
                default:
                    isThatInt = false;
                    choice = 0;
                    break;
            }
        }
    }

