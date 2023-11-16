package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.utils.validators.OrderItemValidator;
import org.junit.jupiter.api.Test;

class OrderItemTest {

    @Test
    void isDrink는_메뉴가_음료인지검사한다() {
        OrderItem orderItem = OrderItem.of("제로콜라", 1, new OrderItemValidator());
        boolean result = orderItem.isDrink();
        assertThat(result).isTrue();
    }

}