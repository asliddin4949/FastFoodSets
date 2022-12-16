package interfaces;

import data.Storage;
import model.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Registration {

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your PhoneNumber: ");
        System.out.print("+998 - ");
        String phoneNumber = scanner.nextLine();
        boolean case1 = Pattern.matches("(33|77|90|91|93|94|95|97|98|99)[0-9]{7}", phoneNumber);
        if (case1) {
            User user = new User();
            if (!user.isExist(Storage.users,phoneNumber)) {

                scanner = new Scanner(System.in);
                System.out.println("Enter your name:");
                String name = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();

                user.setUserId(User.currentId);
                user.setName(name);
                user.setPassword(password);
                user.setPhoneNumber(phoneNumber);
                user.setRole("user");
                Storage.users.add(user);
                Application.startApplication();

            } else {
                System.out.println("This Phone Number has already been Registered!");
                Application.startApplication();
            }

        } else {
            System.out.println("You Entered Wrong Phone Number!");
            Application.startApplication();
        }
    }
}
