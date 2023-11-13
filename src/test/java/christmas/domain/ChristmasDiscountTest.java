package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.utils.validators.DateValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DiscountTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 24, 25})
    void ChristmasDiscount는_25일이전에만_생성된다(int day) {
        // given
        Date date = Date.from(day, new DateValidator());
        // when
        Discount christmas = ChristmasDiscount.from(date);
        // then
        assertThat(christmas).isInstanceOf(ChristmasDiscount.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 27, 30, 31})
    void ChristmasDiscount는_26일이후에는_생성되지않는다(int day) {
        // given
        Date date = Date.from(day, new DateValidator());
        // when
        Discount christmas = ChristmasDiscount.from(date);
        // then
        assertThat(christmas).isNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1000","2, 1100","25, 3400"})
    void ChristmasDiscount는_크리스마스할인금액을_반환한다(int day, int expectedDiscount) {
        // given
        Date date = Date.from(day, new DateValidator());
        // when
        Discount christmas = ChristmasDiscount.from(date);
        int discount = christmas.reqeustDiscountAmount();
        // then
        assertThat(discount).isEqualTo(expectedDiscount);
    }

}