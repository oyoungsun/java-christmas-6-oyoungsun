package christmas.domain.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.PayAmount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PayAmountDtoTest {
    @ParameterizedTest
    @CsvSource(value = {"1234567890, '1,234,567,890원'", "123, '123원'", "12345, '12,345원'"})
    void toString으로_총금액을_문자열로반환한다(int money, String expected) {
        // given
        PayAmount payAmonut = new PayAmount(money);
        PayAmountDto dto = PayAmountDto.fromPayAmonut(payAmonut);
        // when
        String result = dto.getTotalPayAmount();
        // then
        assertThat(result).isEqualTo(expected);
    }
}