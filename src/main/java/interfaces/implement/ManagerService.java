package interfaces.implement;

import Console.AdminConsole;
import Console.Application;
import data.Storage;
import interfaces.Manager;
import model.Order;
import model.Role;
import model.Status;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerService implements Manager {

    private static ManagerService managerService;

    public static ManagerService getInstance() {
        if (managerService == null) {
            managerService = new ManagerService();
        }
        return managerService;
    }

    public void managerMenu() {
        System.out.println("'1' - \"set ready products\" '0' - \"exit\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        if (command == 1) {
            setOrderStatus();
        } else if (command == 0) {
            Application.consoleApplication();
        } else {
            System.out.println("Wrong Command!");
            managerMenu();
        }

    }

    public void setOrderStatus() {
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

    public void showInProgress() {
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

    public void setManager() {
        UserService userService = UserService.getInstance();
        userService.showUsers();
        if (!Storage.users.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();

            for (User user : Storage.users) {
                if (user.getUserId() == id) {
                    user.setRole(Role.MANAGER);
                    System.out.println(user.getName() + "Promoted as Manager!");
                }
            }

        } else {
            System.out.println("There is no any Users!");

        }
        AdminConsole.adminConsole();
    }

}
