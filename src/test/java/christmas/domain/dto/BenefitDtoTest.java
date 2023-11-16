package christmas.domain.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.Benefit;
import org.junit.jupiter.api.Test;

class BenefitDtoTest {
    @Test
    void BenefitDto는_Benefit을_문자열로_변환한다1() {
        // given
        Benefit benefit = new Benefit(true);
        // when
        BenefitDto dto = BenefitDto.fromBenefit(benefit);
        String result = dto.getBenefit();
        // then
        assertThat(result).isEqualTo("샴페인 1개");
    }

    @Test
    void BenefitDto는_Benefit을_문자열로_변환한다2() {
        // given
        Benefit benefit = new Benefit(false);
        // when
        BenefitDto dto = BenefitDto.fromBenefit(benefit);
        String result = dto.getBenefit();
        // then
        assertThat(result).isEqualTo("없음");
    }
}