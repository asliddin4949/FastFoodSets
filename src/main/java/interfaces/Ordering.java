package interfaces;

import model.Order;

import java.util.List;

public interface Ordering {
    void orderProduct();

    void currentOrder();

    void continueOrder();

    void endOrder();
    void showOrders(List<Order> list);
}
