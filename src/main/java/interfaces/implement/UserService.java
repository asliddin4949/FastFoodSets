package interfaces.implement;

import data.Storage;
import model.User;

import java.util.List;

public class UserService {

    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void showUsers() {
        Storage.users.forEach(System.out::println);
    }

    public boolean isExist(List<User> list, String phoneNumber) {
        var user1 = list.stream().filter(user -> user.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);
        return user1 != null;
    }

    public void showMyOrders() {
        var orders = Storage.orders.stream().filter(order -> order.getUser().equals(Storage.currentUser)).toList();
        OrderingService orderingService = OrderingService.getInstance();
        orderingService.showOrders(orders);
    }

}
