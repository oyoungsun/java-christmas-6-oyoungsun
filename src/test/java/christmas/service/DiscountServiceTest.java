package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Date;
import christmas.domain.PayAmount;
import christmas.utils.validators.DateValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DiscountServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {10000, 10001, 100000000})
    void 총주문금액_10000원이상시_DiscountService가_반환된다(int money){
        // given
        PayAmount payAmount = new PayAmount(money);
        Date date =  Date.from(3, new DateValidator());
        // when
        DiscountService service = DiscountService.from(payAmount, date);
        // then
        assertThat(service).isInstanceOf(DiscountService.class);
    }

    @Test
    void 총주문금액_10000원미만시_null이_반환된다(){
        // given
        PayAmount payAmount = new PayAmount(9999);
        Date date =  Date.from(3, new DateValidator());
        // when
        DiscountService service = DiscountService.from(payAmount, date);
        // then
        assertNull(service);
    }
}