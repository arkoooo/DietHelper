package com.dietHelper;
import static com.dietHelper.Add.newPatient;
import static com.dietHelper.Main.*;
import static com.dietHelper.PatientResults.resultMenu;
import static com.dietHelper.Sentences.*;

public class DoctorMenu {
    public static int choice;
    public static void doctorFirstMenu(){
        Main.isThatInt = false;

        //Menu will be displayed until user type correct input
        do{
            whatToDoDoctor();
            if(scanner.hasNextInt()) { // If user type character then menu will be listed once again
                choice = scanner.nextInt();
            }else{
                choice = 0;
                wrongChoice();
                isNeededGreetings = false; //Marking that greeting it's no longer needed
            }
            scanner.nextLine();
        }while(!isThatGoodChoice(choice,1,3));

        switch(choice){
            case 1:
                patientAdmMenu();
                break;
            case 2:
                dietAdmMenu();
                break;
            case 3:
                isNeededGreetings = false;
                isThatInt = false;
                Main.mainMenu();
                break;
            default:
                wrongChoice();
                isThatInt = false;
                break;
        }
    }
    public static void patientAdmMenu() {
        do {
            patientAdmMenuSentence();
            if(scanner.hasNextInt()) { // If user type character then menu will be listed once again
                choice = scanner.nextInt();
                isThatInt = true;
            }else{
                choice = 0;
                wrongChoice();
                isNeededGreetings = false; //Marking that greeting it's no longer needed
            }
            scanner.nextLine();
            switch(choice){
                case 1:
                    newPatient();
                    break;
                case 2:
                    resultMenu();
                    break;
                case 3:
                    break;
                case 4:
                    doctorFirstMenu();
                    break;
                default:
                    isThatInt = false;
                    break;
            }
        } while(!isThatGoodChoice(choice,1,4));
    }
    private static void dietAdmMenu() {
        do {
            dietAdmMenuSentence();
            choice = scanner.nextInt();
            scanner.nextLine();
        } while(!isThatGoodChoice(choice,1,6));
    }
}
