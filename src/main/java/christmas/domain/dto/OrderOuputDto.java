package christmas.domain.dto;

import christmas.domain.Order;

public class OrderOuputDto {
    private final String orders;

    private OrderOuputDto(final Order order){
        this.orders = order.toString();
    }

    public static OrderOuputDto fromOrder(Order order){
        return new OrderOuputDto(order);
    }

    public String getOrders() {
        return this.orders;
    }

}
