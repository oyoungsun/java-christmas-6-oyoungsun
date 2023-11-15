package christmas.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.domain.dto.OrderOuputDto;
import christmas.utils.validators.OrderItemValidator;
import christmas.utils.validators.OrderValidator;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputConvertorTest {

    @Test
    void convertOrderItems는_주어진문자열배열을_OrderItem리스트로반환한다(){
        // given
        InputConvertor convertor = new InputConvertor();
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        // when
        List<OrderItem> result = convertor.convertOrderItems(input, new OrderItemValidator());
        Order order = Order.from(result, new OrderValidator());
        // then
        assertThat(OrderOuputDto.fromOrder(order).getOrders()).contains("티본스테이크 1개",
                "바비큐립 1개",
                "초코케이크 2개",
                "제로콜라 1개");
    }

    @Test
    void convertOrder는_주어진OrderItem배열을_OrderItem리스트로반환한다(){
        // given
        InputConvertor convertor = new InputConvertor();
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        List<OrderItem> items = convertor.convertOrderItems(input, new OrderItemValidator());
        // when

        Order result = convertor.convertOrder(items, new OrderValidator());
        // then
        assertThat(OrderOuputDto.fromOrder(result).getOrders()).contains("티본스테이크 1개",
                "바비큐립 1개",
                "초코케이크 2개",
                "제로콜라 1개");
    }

}