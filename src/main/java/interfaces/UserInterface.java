package interfaces;

import data.Storage;
import service.OrderService;
import service.UserService;

import java.util.Scanner;

public class UserInterface {
    public static void userMenu(){
        Storage.currentOrders.clear();
        System.out.println("'1' - \"Order Product\"  '2' - \"Order Status\"  '0' - \"Exit\"");
        Scanner scanner = new Scanner(System.in);

        int command = scanner.nextInt();

        if(command==1){
            OrderService.orderProduct();
        } else if (command==2) {
            UserService.showMyOrders();
            userMenu();
        }  else if (command==0) {
            Application.startApplication();
        } else {
            System.out.println("Wrong Command!");
            userMenu();
        }

    }
}
