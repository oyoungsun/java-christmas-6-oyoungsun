package christmas.domain.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Benefit;
import christmas.domain.PayAmount;
import christmas.service.BenefitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BenefitDtoTest {
    @Test
    void BenefitDto는_Benefit을_문자열로_변환한다1(){
        // given
        Benefit benefit = new Benefit(true);
        // when
        BenefitDto dto = BenefitDto.fromBenefit(benefit);
        String result = dto.getBenefit();
        // then
        assertThat(result).isEqualTo("샴페인 1개");
    }

    @Test
    void BenefitDto는_Benefit을_문자열로_변환한다2(){
        // given
        Benefit benefit = new Benefit(false);
        // when
        BenefitDto dto = BenefitDto.fromBenefit(benefit);
        String result = dto.getBenefit();
        // then
        assertThat(result).isEqualTo("없음");
    }
}