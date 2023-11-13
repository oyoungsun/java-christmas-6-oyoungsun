package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.discounts.BenefitDiscount;
import christmas.domain.discounts.ChristmasDiscount;
import christmas.domain.discounts.Discount;
import christmas.domain.discounts.WeekdayDiscount;
import christmas.domain.discounts.WeekendDiscount;
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
    @CsvSource(value = {"1, 1000", "2, 1100", "25, 3400"})
    void ChristmasDiscount는_크리스마스할인금액을_반환한다(int day, int expectedDiscount) {
        // given
        Date date = Date.from(day, new DateValidator());
        // when
        Discount christmas = ChristmasDiscount.from(date);
        int discount = christmas.reqeustDiscountAmount();
        // then
        assertThat(discount).isEqualTo(expectedDiscount);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 31})
    void WeekdayDiscount는_평일에만_생성된다(int day) {
        // given
        Date date = Date.from(day, new DateValidator());
        // when
        WeekdayDiscount weekday = WeekdayDiscount.from(date, 1);
        // then
        assertThat(weekday).isInstanceOf(WeekdayDiscount.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 29, 30})
    void WeekdayDiscount는_주말에는_생성되지않는다(int day) {
        // given
        Date date = Date.from(day, new DateValidator());
        // when
        WeekdayDiscount weekday = WeekdayDiscount.from(date, 1);
        // then
        assertThat(weekday).isNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2023", "2, 4046", "20, 40460"})
    void WeekdayDiscount는_평일할인금액을_반환한다(int dessertCount, int expectedDiscount) {
        // given
        Date date = Date.from(3, new DateValidator());
        WeekdayDiscount weekday = WeekdayDiscount.from(date, dessertCount);
        // when
        int discount = weekday.reqeustDiscountAmount();
        // then
        assertThat(discount).isEqualTo(expectedDiscount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 29, 30})
    void WeekendDiscount는_주말에만_생성된다(int day) {
        // given
        Date date = Date.from(day, new DateValidator());
        // when
        WeekendDiscount weekend = WeekendDiscount.from(date, 1);
        // then
        assertThat(weekend).isInstanceOf(WeekendDiscount.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 31})
    void WeekendDiscount는_평일에는_생성되지않는다(int day) {
        // given
        Date date = Date.from(day, new DateValidator());
        // when
        WeekendDiscount weekend = WeekendDiscount.from(date, 1);
        // then
        assertThat(weekend).isNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2023", "2, 4046", "20, 40460"})
    void WeekendDiscount는_주말할인금액을_반환한다(int dessertCount, int expectedDiscount) {
        // given
        Date date = Date.from(1, new DateValidator());
        WeekendDiscount weekend = WeekendDiscount.from(date, dessertCount);
        // when
        int discount = weekend.reqeustDiscountAmount();
        // then
        assertThat(discount).isEqualTo(expectedDiscount);
    }

    @Test
    void BenefitDsicount는_증정이_있으면_생성된다() {
        // given
        boolean isGift = true;
        // when
        BenefitDiscount benefit = BenefitDiscount.from(isGift);
        // then
        assertThat(benefit).isInstanceOf(BenefitDiscount.class);
    }

    @Test
    void BenefitDsicount는_증정이_없으면_생성되지않는다() {
        // given
        boolean isGift = false;
        // when
        BenefitDiscount benefit = BenefitDiscount.from(isGift);
        // then
        assertThat(benefit).isNull();
    }

    @Test
    void BenefitDsicount는_증정금액을_반환한다() {
        // given
        boolean isGift = true;
        BenefitDiscount benefit = BenefitDiscount.from(isGift);
        // when
        int discount = benefit.reqeustDiscountAmount();
        // then
        assertThat(discount).isEqualTo(25000);
    }
}