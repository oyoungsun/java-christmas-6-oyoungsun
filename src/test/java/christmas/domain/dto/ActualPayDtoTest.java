package christmas.domain.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ActualPayDtoTest {

    @Test
    void 총주문금액에서_총혜택금액을_뺸결과를_문자열로_반환한다() {
        // given
        int totalPay = 142000;
        int discount = 31246-25000;
        // when
        ActualPayDto result = ActualPayDto.from(totalPay, discount);
        // then
        assertThat(result.getActualPayAmount()).isEqualTo("135,754원");
    }

}