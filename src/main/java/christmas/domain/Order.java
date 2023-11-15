package christmas.domain;

import christmas.constants.StringConstants;
import christmas.utils.validators.OrderValidator;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<OrderItem> orderItems;

    private Order(final List<OrderItem> orderItem){
        this.orderItems = orderItem;
    }

    public static Order from(final List<OrderItem> orderItems, OrderValidator orderValidator){
        orderValidator.validate(orderItems);
        return new Order(orderItems);
    }

    public int requestTotalPrice(){
        return orderItems.stream().mapToInt(item -> item.requestPrice()).sum();
    }


    public int requestMainCount() {
        return (int) orderItems.stream().mapToInt(item -> item.requestMainCount()).sum();
    }

    public int requestDessertCount() {
        return (int) orderItems.stream().mapToInt(item -> item.requestDessertCount()).sum();
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }
}
