package interfaces;

import data.Storage;
import model.Order;
import model.Status;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    public static void managerMenu() {
        System.out.println("'1' - \"set ready products\" '0' - \"exit\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        if (command == 1) {
            setOrderStatus();
        } else if (command == 0) {
            Application.startApplication();
        } else {
            System.out.println("Wrong Command!");
            managerMenu();
        }

    }

    static void setOrderStatus() {
        showInProgress();
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Order currentOrder = Storage.inProgress.stream().filter(order ->
                order.getOrderId() == id).findFirst().orElse(null);
        if (currentOrder != null) {
            for (Order order : Storage.orders) {
                if (order.equals(currentOrder)) {
                    order.setStatus(Status.READY);
                    managerMenu();
                }
            }
        } else {
            System.out.println("Wrong Order Id!");
            managerMenu();
        }
    }

    static void showInProgress() {
        Storage.inProgress = new ArrayList<>(Storage.orders.stream().filter(order -> order.getStatus().equals(Status.IN_PROGRESS)).toList());
        if (!Storage.inProgress.isEmpty()) {
            for (Order order : Storage.inProgress) {
                System.out.println("Order Id: " + order.getOrderId()
                        + "\nBranch: " + order.getBranch());
            }
        } else {
            System.out.println("There is no In_Progress orders!");
            managerMenu();
        }
    }

}
