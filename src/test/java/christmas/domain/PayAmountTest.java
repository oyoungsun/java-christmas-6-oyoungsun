package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PayAmountTest {

    @ParameterizedTest
    @CsvSource(value = {"1234567890, 1234567890", "123, 123", "12345, 12345"})
    void getTotalOrderAmount으로_총금액을_반환한다(int money, int expected){
        // given
        PayAmount payAmonut = new PayAmount(money);
        // when
        int result = payAmonut.getTotalOrderAmount();
        // then
        assertThat(result).isEqualTo(expected);
    }
}