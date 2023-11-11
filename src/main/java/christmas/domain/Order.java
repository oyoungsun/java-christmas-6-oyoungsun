package christmas.domain;

import christmas.utils.validators.OrderValidator;
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

}
