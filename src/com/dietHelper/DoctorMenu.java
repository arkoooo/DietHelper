package com.dietHelper;
import static com.dietHelper.Add.newPatient;
import static com.dietHelper.Main.*;
import static com.dietHelper.Sentences.*;

public class DoctorMenu {
    public static int choice;
    private static boolean goBack = false;
    private static boolean isThatInt = false;
    public static void doctorFirstMenu(){
        Main.isThatInt = false;

        //Menu will be displayed until user type correct input
        do{
            whatToDoDoctor();
            if(scanner.hasNextInt()) { // If user type character then menu will be listed once again
                choice = scanner.nextInt();
                Main.isThatInt = true;
            }else{
                wrongChoice();
                choice = 0;
                isNeededGreetings = false; //Marking that greeting it's no longer needed
            }
            scanner.nextLine();
        }while(!isThatGoodChoice(choice,1,3) && Main.isThatInt);

        switch(choice){
            case 1:
                choice = 0;
                do {
                    patientAdmMenuSentence();
                    if(scanner.hasNextInt()) { // If user type character then menu will be listed once again
                        choice = scanner.nextInt();
                        isThatInt = true;
                    }else{
                        wrongChoice();
                        choice = 0;
                        isNeededGreetings = false; //Marking that greeting it's no longer needed
                    }
                    scanner.nextLine();
                    switch(choice){
                        case 1:
                            newPatient();
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            goBack=true;
                            break;
                        default:
                            isThatInt = false;
                            choice = 0;
                            break;
                    }
                } while(!isThatGoodChoice(choice,1,4) && !goBack && !isThatInt);
                break;
            case 2:
                choice = 0;
                do {
                    dietAdmMenuSentence();
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } while(!isThatGoodChoice(choice,1,6));
                break;
            case 3:
                choice = 0;
                isNeededGreetings = false;
                isThatInt = false;
                Main.mainMenu();
                break;
            default:
                wrongChoice();
                choice = 0;
                isThatInt = false;
                break;
        }
    }
}
