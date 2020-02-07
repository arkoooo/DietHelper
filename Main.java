package com.dietHelper;

import java.util.Scanner;

import static com.dietHelper.Add.patientList;
import static com.dietHelper.Sentences.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static int choice;
    public static boolean goodChoice = false;
    public static boolean isNeededGreetings = true;

    public static void main(String[] args) {
                createExamplePatients();
                mainMenu();
    }

    private static void createExamplePatients() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Arek");
        patient.setSurname("Kubek");

        Patient patient2 = new Patient();
        patient2.setId(2);
        patient2.setName("Paula");
        patient2.setSurname("Sedi");

        patientList.add(patient);
        patientList.add(patient2);
        PatientResults.selectedPatient = 1;
    }

    public static void mainMenu() {
            do{
                //The first time run of program greeting is displayed
                if(isNeededGreetings){
                    hello();
                    isNeededGreetings = false;
                }
                Sentences.mainMenuSentence();
                if(scanner.hasNextInt()) { // If user type character then menu will be listed once again
                    choice = scanner.nextInt();
                }else{
                    goodChoice = false;
                    wrongChoice();
                }
                scanner.nextLine();
            }while(!isThatGoodChoice(choice,1,3) && !goodChoice); //Menu will be displayed until user type correct input



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

