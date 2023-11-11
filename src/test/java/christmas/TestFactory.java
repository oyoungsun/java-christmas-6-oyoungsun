package christmas;

import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.utils.validators.OrderItemValidator;
import christmas.utils.validators.OrderValidator;
import java.util.List;

public class TestFactory {    //테스트에 필요한 객체를 생성한다.
    public static List<OrderItem> createOrderItems() {
        OrderItemValidator validator = new OrderItemValidator();
        return List.of(OrderItem.of("초코케이크", 1, validator));
    }

    public static Order createOrder() {
        OrderItemValidator validator = new OrderItemValidator();
        List<OrderItem> items = List.of(OrderItem.of("타파스", 1, validator),
                OrderItem.of("제로콜라", 1, validator));
        return Order.from(items, new OrderValidator());
    }

}
