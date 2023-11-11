package christmas;

import christmas.domain.OrderItem;
import christmas.utils.validators.OrderItemValidator;
import java.util.List;

public class TestFactory {    //테스트에 필요한 객체를 생성한다.
    public static List<OrderItem> createOrderItems() {
        OrderItemValidator validator = new OrderItemValidator();
        return List.of(OrderItem.of("초코케이크", 1, validator));
    }

}
