package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.TestFactory;
import christmas.utils.validators.OrderValidator;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void OrderItem리스트_받으면_주문객체를_생성한다() {
        //given
        List<OrderItem> orderItmeList = TestFactory.createOrderItems();
        //when
        Order order = Order.from(orderItmeList, new OrderValidator());
        //then
        assertThat(order).isInstanceOf(Order.class);
    }

    @Test
    void requestTotalPrice_로_주문총금액을_반환한다(){
        //given
        Order order = TestFactory.createOrder();
        //when
        int result = order.requestTotalPrice();
        //then
        assertThat(result).isEqualTo(8500);
    }

    @Test
    void requestMainCount는_주문에서_메인의_개수를센다() {
        //given
        List<OrderItem> orderItmeList = TestFactory.createOrderItems();
        Order order = Order.from(orderItmeList, new OrderValidator());
        //when
        int mainCount = order.requestMainCount();
        //then
        assertThat(mainCount).isEqualTo(2);
    }

    @Test
    void requestDessertCount는_주문에서_디저트의_개수를센다() {
        //given
        List<OrderItem> orderItmeList = TestFactory.createOrderItems();
        Order order = Order.from(orderItmeList, new OrderValidator());
        //when
        int dessertCount = order.requestDessertCount();
        //then
        assertThat(dessertCount).isEqualTo(4);
    }

}