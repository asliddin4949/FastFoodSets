package interfaces;

import data.Storage;

import model.Order;
import model.Product;
import model.User;

import java.util.Scanner;

public class Admin {

    public static void adminMenu(){
        System.out.println("'1' - \"Users\"  '2' - \"Add Product\"  '3' - \"Show Products\"  '0' - \"Exit\""
                         +"\n'4' - \"Add Branch\"  '5' - \"Show Branches\"  '6' - \"Show Orders\" '7' - \"Set Manager\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        if(command==1){
            Storage.dynamicUser.showUsers();
            adminMenu();
        } else if (command==0) {
            Application.startApplication();
        } else if (command==2) {
            Product product = new Product();
            product.addProduct();
        } else if (command==3) {
            Product product = new Product();
            product.showProducts();
            adminMenu();
        } else if (command==4) {
            Storage.dynamicBranch.addBranch();
        } else if (command==5) {
            Storage.dynamicBranch.showBranches();
            adminMenu();
        } else if (command==6) {
            Order order = new Order();
            order.showOrders(Storage.orders);
            adminMenu();
        } else if (command==7) {
            setManager();
        } else {
            System.out.println("Wrong command!");
            adminMenu();
        }
    }
    static void setManager(){
        Storage.dynamicUser.showUsers();
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
