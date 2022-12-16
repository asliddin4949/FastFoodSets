package interfaces;

import data.Storage;
import model.Product;
import model.User;
import service.BranchService;
import service.OrderService;
import service.ProductService;
import service.UserService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Admin {
    public static void adminMenu(){
        System.out.println("'1' - \"Users\"  '2' - \"Add Product\"  '3' - \"Show Products\"  '0' - \"Exit\""
                         +"\n'4' - \"Add Branch\"  '5' - \"Show Branches\"  '6' - \"Show Orders\" '7' - \"Set Manager\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        if(command==1){
            UserService.showUsers();
            adminMenu();
        } else if (command==0) {
            Application.startApplication();
        } else if (command==2) {
            ProductService.addProduct();
        } else if (command==3) {
            ProductService.showProducts();
            adminMenu();
        } else if (command==4) {
            BranchService.addBranch();
        } else if (command==5) {
            BranchService.showBranches();
            adminMenu();
        } else if (command==6) {
            OrderService.showOrders(Storage.orders);
            adminMenu();
        } else if (command==7) {
            setManager();
        } else {
            System.out.println("Wrong command!");
            adminMenu();
        }
    }
    static void setManager(){
        UserService.showUsers();
        if(!Storage.users.isEmpty()){
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();

            for (User user : Storage.users) {
                if(user.getUserId()==id){
                    user.setRole("manager");
                    System.out.println(user.getName()+"Promoted as Manager!");
                }
            }
            adminMenu();
        }else {
            System.out.println("There is no any Users!");
            adminMenu();
        }



    }


}
