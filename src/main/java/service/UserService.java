package service;

import data.Storage;
import model.User;

public class UserService {
    public static User dynamicUser;
    public static User getDynamicUser(String phoneNumber){
      return Storage.users.stream().filter(user -> user.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);
    }
    public static void showUsers(){
        Storage.users.forEach(System.out::println);
    }

    public static void showMyOrders(){
        var orders = Storage.orders.stream().filter(order -> order.getUser().equals(dynamicUser)).toList();
        OrderService.showOrders(orders);
    }
}
