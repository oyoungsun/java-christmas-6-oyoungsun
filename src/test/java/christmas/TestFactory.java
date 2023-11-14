package christmas;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.domain.PayAmount;
import christmas.service.DiscountService;
import christmas.utils.validators.DateValidator;
import christmas.utils.validators.OrderItemValidator;
import christmas.utils.validators.OrderValidator;
import java.util.List;
import org.mockito.internal.matchers.Or;

public class TestFactory {    //테스트에 필요한 객체를 생성한다.
    public static List<OrderItem> createOrderItems() {
        OrderItemValidator validator = new OrderItemValidator();
        return List.of(OrderItem.of("초코케이크", 1, validator),
                OrderItem.of("티본스테이크", 2, validator),
                OrderItem.of("아이스크림", 3, validator));
    }

    public static Order createOrder() {
        OrderItemValidator validator = new OrderItemValidator();
        List<OrderItem> items = List.of(OrderItem.of("타파스", 1, validator),
                OrderItem.of("제로콜라", 1, validator));
        return Order.from(items, new OrderValidator());
    }

    public static DiscountService createDiscontService() {
        PayAmount amount = new PayAmount(142000);
        Date date = Date.from(3, new DateValidator());
        return DiscountService.from(amount, date);
    }

}
