package christmas.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.PayAmount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BenefitServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"12000, true", "1000, false"})
    void BenefitService는_총주문금액을_받아_증정여부를판단한다(int money, boolean expected){
        //given
        PayAmount payAmount = new PayAmount(money);
        // when
        BenefitService service = BenefitService.from(payAmount);
        // then
        assertThat(service.isGift()).isEqualTo(expected);
    }


}