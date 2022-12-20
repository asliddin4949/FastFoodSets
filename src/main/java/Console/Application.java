package Console;


import data.Storage;
import interfaces.SignInSignUp;
import interfaces.implement.ManagerService;
import interfaces.implement.Registration;
import model.Role;

import java.util.Scanner;

public class Application {
    public static void consoleApplication() {
        System.out.println("~ ~ ~ Set Fast Food by Muminov's ~ ~ ~");
        System.out.println("'1' - \"Sign in\"  '2' - \"Sign Up\"  '0' - \"Exit\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        SignInSignUp signInSignUp = Registration.getInstance();
        if (command == 1) {
            Storage.currentUser = signInSignUp.signIn();
            if (Storage.currentUser == null) {
                System.out.println("You are not signed up!");
                Application.consoleApplication();
            } else if (Storage.currentUser.equals(Storage.admin)) {
                AdminConsole.adminConsole();
            } else if (Storage.currentUser.getRole().equals(Role.MANAGER)) {
                ManagerService managerService = ManagerService.getInstance();
                managerService.managerMenu();
            } else {
                UserConsole.userConsole();
            }
        } else if (command == 2) {
            signInSignUp = Registration.getInstance();
            signInSignUp.signUp();
            Application.consoleApplication();
        } else if (command == 0) {
            System.exit(0);
        } else {
            System.out.println("Wrong command!");
            consoleApplication();
        }
    }

}
