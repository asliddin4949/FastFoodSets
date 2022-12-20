package interfaces.implement;

import data.Storage;
import interfaces.SignInSignUp;
import model.Role;
import model.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Registration implements SignInSignUp {

    private static Registration signInSignUp;

    public static Registration getInstance() {
        if (signInSignUp == null) {
            signInSignUp = new Registration();
        }
        return signInSignUp;
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your PhoneNumber: ");
        System.out.print("+998 - ");
        String phoneNumber = scanner.nextLine();
        boolean case1 = Pattern.matches("(33|77|90|91|93|94|95|97|98|99)[0-9]{7}", phoneNumber);
        if (case1) {
            User user = new User();
            if (!user.isExist(Storage.users, phoneNumber)) {

                scanner = new Scanner(System.in);
                System.out.println("Enter your name:");
                String name = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();

                user.setUserId(User.currentId);
                user.setName(name);
                user.setPassword(password);
                user.setPhoneNumber(phoneNumber);
                user.setRole(Role.USER);
                User.currentId++;
                Storage.users.add(user);

            } else {

                System.out.println("This Phone Number has already been Registered!");

            }
        } else {

            System.out.println("You Entered Wrong Phone Number!");

        }
    }

    @Override
    public User signIn() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Phone Number (without Country Code): ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        if(phoneNumber.equals("admin1")&&password.equals("admin1")){
            return Storage.admin;
        }
        return Storage.users.stream().filter(user1 ->
                        user1.getPhoneNumber().equals(phoneNumber) && user1.getPassword().equals(password))
                .findFirst().orElse(null);

    }

}
