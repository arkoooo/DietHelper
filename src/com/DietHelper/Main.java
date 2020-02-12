package com.DietHelper;

import static com.DietHelper.Sentences.*;

public class Main {

    public static void main(String[] args) {
                Examples.createExamplePatients();
                mainMenu();
    }

    public static void mainMenu() {
            do{
                //The first time run of program greeting is displayed
                if(Variables.isNeededGreetings){
                    hello();
                    Variables.isNeededGreetings = false;
                }
                System.out.println(mainMenuSentence());
                if(Variables.scanner.hasNextInt()) { // If user type character then menu will be listed once again
                    Variables.choice = Variables.scanner.nextInt();
                }else{
                    Variables.goodChoice = false;
                    wrongChoice();
                }
                Variables.scanner.nextLine();
            }while(!isThatGoodChoice(Variables.choice,1,3) && !Variables.goodChoice); //Menu will be displayed until user type correct input



            switch (Variables.choice){
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

