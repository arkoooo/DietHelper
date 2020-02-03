package com.dietHelper;
import static com.dietHelper.Main.scanner;
import static com.dietHelper.Sentences.*;

public class DoctorMenu {
    public static int choice;
    public static void doctorFirstMenu(){

        /* Protection loop against wrong selection */
        do{
            whatToDoDoctor();
            choice = scanner.nextInt();
            scanner.nextLine();
        }while(choice < 1 || choice > 3);

        switch(choice){
            case 1:
                choice = 0;
                do {
                    patientAdministrationMenu();
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } while(choice < 1 || choice > 5);
                break;
            case 2:
                choice = 0;
                do {
                    dietAdministrationMenu();
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } while(choice < 1 || choice >6);
                break;
            default:
                wrongChoice();
                break;
        }
    }
}
