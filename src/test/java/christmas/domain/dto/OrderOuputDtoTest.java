package christmas.domain.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.TestFactory;
import christmas.domain.Order;
import org.junit.jupiter.api.Test;

class OrderOuputDtoTest {
    @Test
    void fromOrder는Order를_OrderDto로_변환한다(){
        Order order = TestFactory.createOrder();
        OrderOuputDto result = OrderOuputDto.fromOrder(order);
        assertThat(result.getOrders()).isEqualTo(
                "타파스 1개\n"
                        + "제로콜라 1개\n");
    }
}