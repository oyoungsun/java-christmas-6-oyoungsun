package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.TestFactory;
import christmas.utils.validators.OrderValidator;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void OrderItem리스트_받으면_주문객체를_생성한다() {
        List<OrderItem> orderItmeList = TestFactory.createOrderItems();
        Order order = Order.from(orderItmeList, new OrderValidator());
        assertThat(order).isInstanceOf(Order.class);
    }

}