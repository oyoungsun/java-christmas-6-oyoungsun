package christmas.domain.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.TestFactory;
import christmas.service.DiscountService;
import org.junit.jupiter.api.Test;

class DiscountDtoTest {
    @Test
    void toString으로_혜택_내역을_반환한다() {
        // given
        DiscountService discountService = TestFactory.createDiscontService();
        discountService.discount(0, 2, true);
        // when
        DiscountDto result = DiscountDto.fromDiscount(discountService.getTotalDiscounts());
        // then
        assertThat(result.getTotalDiscount()).contains(
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원");
    }

}