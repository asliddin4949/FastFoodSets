package interfaces;

import model.Order;

import java.util.List;

public interface Ordering {
    void orderProduct();
    void showOrders(List<Order> list);
}
