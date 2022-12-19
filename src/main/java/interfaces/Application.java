package interfaces;


import data.Storage;

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
        Storage.currentUser = Storage.currentUser.getDynamicUser(phoneNumber);
        if (phoneNumber.equals("admin1") && password.equals("admin1")) {
            Admin.adminMenu();
        } else if (Storage.currentUser == null) {
            System.out.println("You are not signed up!");
            startApplication();
        } else if (Storage.currentUser.getRole().equals("manager")) {
            Manager.managerMenu();
        } else {
            UserInterface.userMenu();
        }
    }

}
