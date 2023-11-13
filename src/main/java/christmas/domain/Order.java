package christmas.domain;

import christmas.constants.StringConstants;
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

    public int requestTotalPrice(){
        return orderItems.stream().mapToInt(item -> item.requestPrice()).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        orderItems.stream().map(
                item -> item.toString()).
                forEach(item -> sb.append(item).append(StringConstants.ENTER)
        );
        return sb.toString();
    }
}
