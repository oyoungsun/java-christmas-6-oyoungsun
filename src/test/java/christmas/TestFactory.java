package christmas;

import christmas.domain.OrderItem;
import java.util.List;

public class TestFactory {    //테스트에 필요한 객체를 생성한다.
    public static List<OrderItem> createOrderItems() {
        return List.of(new OrderItem());
    }

}
