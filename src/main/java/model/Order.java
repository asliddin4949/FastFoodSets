package model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Order {


    int orderId;
    User user;
    Branch branch;
    BigDecimal totalPrice;
    List<CurrentOrder> orderedProducts;
    Status status;

    //*******************Behaviors******************************
    public void showOrders(List<Order> list) {
        for (Order order : list) {
            System.out.println("Order ID: " + order.getOrderId()
                    + "\nBranch: " + order.getBranch()
                    + "\nUser: " + order.getUser()
                    + "\nTotal Price: " + order.getTotalPrice()
                    + "\nStatus: " + order.getStatus()
                    + "\n- - - - - - - - - - - - - - - - ");
            for (CurrentOrder orderedProduct : order.getOrderedProducts()) {
                System.out.println("Product: " + orderedProduct.getProduct()
                        + "\nQuantity: " + orderedProduct.getQuantity()
                        + "\nCost: " + orderedProduct.getCost());
            }
            System.out.println("* * * * * * * * * * * * * * * * * ");
        }
    }

    public Order() {
    }

    public Order(int orderId, User user, Branch branch, BigDecimal totalPrice, Status status, List<CurrentOrder> orderedProducts) {
        this.orderId = orderId;
        this.user = user;
        this.branch = branch;
        this.totalPrice = totalPrice;
        this.orderedProducts = orderedProducts;
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nOrder - " + orderId +
                "\nUser:" + user +
                "\nBranch: " + branch +
                "\nTotalPrice: " + totalPrice +
                "\nOrderedProducts:" + orderedProducts +
                "\nStatus: " + status +
                "\n- - - - - - - - - - - - ";
    }

    //************************Counter Order ID*************************************
    public static int currentId = 1;

    {
        currentId++;
    }
}
