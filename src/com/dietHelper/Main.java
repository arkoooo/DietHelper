package com.dietHelper;

import java.util.Scanner;

import static com.dietHelper.Sentences.hello;
import static com.dietHelper.Sentences.wrongChoice;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static int choice;
    public static boolean goodChoice;

    public static void main(String[] args) {
            /* Protection loop against wrong selection **/
            do{
                firstMenu();
            } while(!goodChoice);
    }

        public static void firstMenu() {
        // The loop captures invalid input
        do {
            hello();
            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                goodChoice = true;
            }else{
                scanner.nextLine();
                wrongChoice();
            }
        }while(!goodChoice);

            switch (choice) {
                case 1:
                    PatientMenu.patientMenu();
                    goodChoice = true;
                    break;
                case 2:
                    DoctorMenu.doctorFirstMenu();
                    goodChoice = true;
                    break;
                default:
                    wrongChoice();
            }
        }
    }

