package Console;


import interfaces.SignInSignUp;
import interfaces.implement.Registration;

import java.util.Scanner;

public class Application {
    public static void consoleApplication() {
        System.out.println("~ ~ ~ Set Fast Food by Muminov's ~ ~ ~");
        System.out.println("'1' - \"Sign in\"  '2' - \"Sign Up\"  '0' - \"Exit\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        if (command == 1) {
            SignInSignUp signInSignUp = Registration.getInstance();
            signInSignUp.signIn();
        } else if (command == 2) {
            SignInSignUp signInSignUp = Registration.getInstance();
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
