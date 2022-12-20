package Console;

import data.Storage;

import interfaces.Delete;
import interfaces.Manager;
import interfaces.Ordering;
import interfaces.Update;
import interfaces.implement.*;
import model.Branch;
import model.Product;

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
            Branch branch = new Branch();
            branch.addBranch();
            adminConsole();
        } else if (command == 5) {
            Branch branch = new Branch();
            branch.showBranches();
            adminConsole();
        } else if (command == 6) {
            Ordering ordering = OrderingService.getInstance();
            ordering.showOrders(Storage.orders);
            adminConsole();
        } else if (command == 7) {
            Manager manager = ManagerService.getInstance();
            manager.setManager();
        } else if (command == 8) {
            Update update = UpdateBranch.getInstance();
            update.update();
            adminConsole();
        } else if (command == 9) {
            Update update = UpdateProduct.getInstance();
            update.update();
            adminConsole();
        } else if (command == 10) {
            Delete delete = DeleteBranch.getInstance();
            delete.delete();
            adminConsole();
        } else if (command == 11) {
            Delete delete = DeleteProduct.getInstance();
            delete.delete();
            adminConsole();
        } else {
            System.out.println("Wrong command!");
            adminConsole();
        }
    }

}
