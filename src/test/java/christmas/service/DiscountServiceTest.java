package christmas.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.TestFactory;
import christmas.domain.Date;
import christmas.domain.PayAmount;
import christmas.utils.validators.DateValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DiscountServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {10000, 10001, 100000000})
    void 총주문금액_10000원이상시_DiscountService가_반환된다(int money) {
        // given
        PayAmount payAmount = new PayAmount(money);
        Date date = Date.from(3, new DateValidator());
        // when
        DiscountService service = DiscountService.from(payAmount, date);
        // then
        assertThat(service).isInstanceOf(DiscountService.class);
    }

    @Test
    void 총주문금액_10000원미만시_이벤트가_적용되지않는다() {
        // given
        PayAmount payAmount = new PayAmount(9999);
        Date date = Date.from(3, new DateValidator());
        // when
        DiscountService service = DiscountService.from(payAmount, date);
        // then
        assertThat(service.getTotalDiscounts().size()).isEqualTo(0);
    }

    @Test
    void requestTotalDiscountAmount으로_총혜택금액을_반환한다() {
        // given
        DiscountService discountService = TestFactory.createDiscontService();
        discountService.discount(0, 2, true);
        // when
        int result = discountService.requestTotalDiscountAmount();
        // then
        assertThat(result).isEqualTo(31246);
    }

    @Test
    void requestActualDiscountAmount으로_실제혜택금액을_반환한다() {
        // given
        DiscountService discountService = TestFactory.createDiscontService();
        discountService.discount(0, 2, true);
        // when
        int result = discountService.requestActualDiscountAmount();
        // then
        assertThat(result).isEqualTo(6246);

    }
}