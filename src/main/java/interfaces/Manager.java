package interfaces;

import data.Storage;
import model.Order;
import model.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    static List<Order> inProgress;

    public static void managerMenu() {
        System.out.println("'1' - \"set ready products\" '0' - \"exit\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        if (command == 1) {
            setStatus();
        } else if (command == 0) {
            Application.startApplication();
        } else {
            System.out.println("Wrong Command!");
            managerMenu();
        }

    }

    static void setStatus() {
        showInProgress();
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Order currentOrder = inProgress.stream().filter(order ->
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
        inProgress = new ArrayList<>(Storage.orders.stream().filter(order -> order.getStatus().equals(Status.IN_PROGRESS)).toList());
        if (!inProgress.isEmpty()) {
            for (Order order : inProgress) {
                System.out.println("Order Id: " + order.getOrderId()
                        + "\nBranch: " + order.getBranch());
            }
        } else {
            System.out.println("There is no In_Progress orders!");
            managerMenu();
        }
    }

}
