package christmas.domain.dto;

import christmas.constants.StringConstants;
import christmas.domain.Order;

public class OrderOuputDto {
    private final String orders;

    private OrderOuputDto(final Order order){
        StringBuilder sb = new StringBuilder();
        order.getOrderItems().stream().map(
                        item -> item.getOrderItemString()).
                forEach(item -> sb.append(item).append(StringConstants.ENTER)
                );
        this.orders = sb.toString();
    }

    public static OrderOuputDto fromOrder(Order order){
        return new OrderOuputDto(order);
    }

    public String getOrders() {
        return this.orders;
    }

}
