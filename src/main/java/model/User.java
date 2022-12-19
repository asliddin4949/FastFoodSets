package model;

import data.Storage;
import interfaces.implement.OrderingService;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class User implements CheckStorage<User> {
    //*****************Fields**********************
    private int userId;
    private String phoneNumber;
    private String name;
    private String password;
    private Role role;

    //*******************Behaviors******************************
    @Override
    public String toString() {
        return "\nUserId: " + userId +
                "\nPhoneNumber: +998 - " + phoneNumber +
                "\nName: " + name +
                "\n- - - - - - - - - -";
    }

    public void showMyOrders() {
        var orders = Storage.orders.stream().filter(order -> order.getUser().equals(Storage.currentUser)).toList();
        OrderingService orderingService = OrderingService.getInstance();
        orderingService.showOrders(orders);
    }

    public User getDynamicUser(String phoneNumber) {
        return Storage.users.stream().filter(user -> user.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);
    }

    public void showUsers() {
        Storage.users.forEach(System.out::println);
    }

    @Override
    public boolean isExist(List<User> list, String phoneNumber) {
        var user1 = list.stream().filter(user -> user.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);
        return user1 != null;
    }

    //************************Counter User ID*************************************
    public static int currentId = 0;

    {
        currentId++;
    }
}
