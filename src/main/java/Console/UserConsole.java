package Console;

import data.Storage;
import interfaces.implement.OrderingService;

import java.util.Scanner;

public class UserConsole {
    public static void userConsole() {
        Storage.currentOrders.clear();
        System.out.println("'1' - \"Order Product\"  '2' - \"Order Status\"  '0' - \"Exit\"");
        Scanner scanner = new Scanner(System.in);

        int command = scanner.nextInt();

        if (command == 1) {
            OrderingService orderingService = OrderingService.getInstance();
            orderingService.orderProduct();
        } else if (command == 2) {
            Storage.currentUser.showMyOrders();
            userConsole();
        } else if (command == 0) {
            Application.consoleApplication();
        } else {
            System.out.println("Wrong Command!");
            userConsole();
        }
    }

}
