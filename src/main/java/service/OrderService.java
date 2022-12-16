package service;

import data.Storage;
import interfaces.UserInterface;
import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    public static void orderProduct() {
        BranchService.showBranches();
        System.out.println("Choose Branch Id :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        var currentBranch = Storage.branches.stream().filter(branch -> branch.getId() == id).findFirst().orElse(null);
        if (currentBranch != null) {
            BranchService.dynamicBranch = currentBranch;
            currentOrder();
        } else {
            System.out.println("Wrong Branch Id");
            UserInterface.userMenu();
        }
    }

    static void currentOrder() {
        System.out.println("'1' - \"Continue\" '0' - \"End Order\"");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        if(command==1){
            continueOrder();
        } else if (command==0) {
           endOrder();
        }else {
            System.out.println("Wrong Command!");
            currentOrder();
        }
    }
    static void  endOrder(){
            var currentOrders = new ArrayList<>(Storage.currentOrders);
            if(!currentOrders.isEmpty()) {
                BigDecimal totalCost = currentOrders.stream().map(CurrentOrder::getCost).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
                Order order = new Order(Order.currentId,
                                        UserService.dynamicUser,
                                        BranchService.dynamicBranch,
                                        totalCost,
                                        Status.IN_PROGRESS,
                                        currentOrders);
                Storage.orders.add(order);
                System.out.println("Thank you for Order! Your Order will be READY soon!");
                UserInterface.userMenu();
            }else {
                System.out.println("Thank you!");
                UserInterface.userMenu();
            }
    }
    static void continueOrder(){
        Product currentProduct = getProduct();
        if (currentProduct != null) {
            System.out.println("Enter Quantity:");
            Scanner scanner = new Scanner(System.in);
            double quantity = scanner.nextDouble();
            if (quantity > 0) {
                BigDecimal cost = currentProduct.getPrice().multiply(BigDecimal.valueOf(quantity));
                CurrentOrder currentOrder = new CurrentOrder(currentProduct, quantity, cost);
                Storage.currentOrders.add(currentOrder);
                currentOrder();
            } else {
                System.out.println("Wrong Quantity");
                currentOrder();
            }
        } else {
            System.out.println("Wrong Product Id!");
            currentOrder();
        }
    }

    static Product getProduct() {
        ProductService.showProducts();
        System.out.println("Choose Product Id :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        return Storage.products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public static void showOrders(List<Order> list){
        for (Order order : list) {
            System.out.println("Order ID: " + order.getOrderId()
                               + "\nBranch: "+order.getBranch()
                               + "\nUser: "+order.getUser()
                               +  "\nTotal Price: "+order.getTotalPrice()
                                + "\nStatus: "+order.getStatus()
                                +"\n- - - - - - - - - - - - - - - - ");
            for (CurrentOrder orderedProduct : order.getOrderedProducts()) {
                System.out.println("Product: "+orderedProduct.getProduct()
                                    +"\nQuantity: "+orderedProduct.getQuantity()
                                    +"\nCost: "+orderedProduct.getCost());
            }
            System.out.println("* * * * * * * * * * * * * * * * * ");
        }
    }

}
