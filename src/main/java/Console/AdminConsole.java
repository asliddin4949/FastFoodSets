package Console;

import data.Storage;

import interfaces.*;
import interfaces.implement.*;


import java.util.Scanner;

public class AdminConsole {

    public static void adminConsole() {
        System.out.println("""
                '1' - "Users"  '2' - "Add Product"  '3' - "Show Products"  '0' - "Exit"
                '4' - "Add Branch"  '5' - "Show Branches"  '6' - "Show Orders"\s
                '7' - "Set Manager" '8' - "Update Branch Info" '9' - "Update Product Info"
                '10' - "Delete Branch"  '11' - "Delete Product\"""");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        ProductService productService = ProductService.getInstance();
        UserService userService = UserService.getInstance();
        BranchService branchService = BranchService.getInstance();
        if (command == 1) {
            userService.showUsers();
            adminConsole();
        } else if (command == 0) {
            Application.consoleApplication();
        } else if (command == 2) {
            productService.add();
        } else if (command == 3) {
            productService.show();
            adminConsole();
        } else if (command == 4) {
            branchService.add();
            adminConsole();
        } else if (command == 5) {
            branchService.show();
            adminConsole();
        } else if (command == 6) {
            Ordering ordering = OrderingService.getInstance();
            ordering.showOrders(Storage.orders);
            adminConsole();
        } else if (command == 7) {
            Manager manager = ManagerService.getInstance();
            manager.setManager();
        } else if (command == 8) {
            branchService.update();
            adminConsole();
        } else if (command == 9) {
            productService.update();
            adminConsole();
        } else if (command == 10) {
            branchService.delete();
            adminConsole();
        } else if (command == 11) {
            productService.delete();
            adminConsole();
        } else {
            System.out.println("Wrong command!");
            adminConsole();
        }
    }

}
