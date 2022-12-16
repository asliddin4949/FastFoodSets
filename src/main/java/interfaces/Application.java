package interfaces;

import data.Storage;
import model.User;
import service.UserService;

import java.util.Scanner;

public class Application {
    public static void startApplication() {
        System.out.println("~ ~ ~ Set Fast Food by Muminov's ~ ~ ~");
        System.out.println("'1' - \"Sign in\"  '2' - \"Sign Up\"  '0' - \"Exit\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        if (command == 1) {
            logIn();
        } else if (command == 2) {
            Registration.registerUser();
        } else if (command == 0) {
            System.exit(0);
        } else {
            System.out.println("Wrong command!");
            startApplication();
        }
    }

    static void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Phone Number (without Country Code): ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        if (phoneNumber.equals("admin1") && password.equals("admin1")) {
            Admin.adminMenu();
        } else {
            UserService.dynamicUser = UserService.getDynamicUser(phoneNumber);
            if (UserService.dynamicUser == null) {
                System.out.println("You are not signed up!");
                startApplication();
            } else if (UserService.dynamicUser.getRole().equals("manager")) {
                Manager.managerMenu();
            } else {
                UserInterface.userMenu();
            }
        }
    }
}
