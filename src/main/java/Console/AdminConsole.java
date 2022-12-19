package Console;

import data.Storage;

import interfaces.implement.ManagerService;
import interfaces.implement.OrderingService;
import model.Product;

import java.util.Scanner;

public class AdminConsole {

    public static void adminConsole() {
        System.out.println("'1' - \"Users\"  '2' - \"Add Product\"  '3' - \"Show Products\"  '0' - \"Exit\""
                + "\n'4' - \"Add Branch\"  '5' - \"Show Branches\"  '6' - \"Show Orders\" '7' - \"Set Manager\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        if (command == 1) {
            Storage.currentUser.showUsers();
            adminConsole();
        } else if (command == 0) {
            Application.consoleApplication();
        } else if (command == 2) {
            Product product = new Product();
            product.addProduct();
        } else if (command == 3) {
            Product product = new Product();
            product.showProducts();
            adminConsole();
        } else if (command == 4) {
            Storage.currentBranch.addBranch();
        } else if (command == 5) {
            Storage.currentBranch.showBranches();
            adminConsole();
        } else if (command == 6) {
            OrderingService orderingService = OrderingService.getInstance();
            orderingService.showOrders(Storage.orders);
            adminConsole();
        } else if (command == 7) {
            ManagerService managerService = ManagerService.getInstance();
            managerService.setManager();
        } else {
            System.out.println("Wrong command!");
            adminConsole();
        }
    }

}
