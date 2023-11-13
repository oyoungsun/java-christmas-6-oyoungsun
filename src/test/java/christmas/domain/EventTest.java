package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EventTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 1000, 4999})
    void 총혜택금액이_5000원미만이면_없음을_반환(int money){
        // when
        Event event = new Event(money);
        // then
        assertThat(event.toString()).isEqualTo("없음");
    }
    @ParameterizedTest
    @ValueSource(ints = {5000, 9999})
    void 총혜택금액이_5000원이상_10000원미만이면_별을_반환(int money){
        // when
        Event event = new Event(money);
        // then
        assertThat(event.toString()).isEqualTo("별");
    }
    @ParameterizedTest
    @ValueSource(ints = {10000, 19999, 15000})
    void 총혜택금액이_10000원이상_20000원미만이면_트리을_반환(int money){
        // when
        Event event = new Event(money);
        // then
        assertThat(event.toString()).isEqualTo("트리");
    }
    @ParameterizedTest
    @ValueSource(ints = {20000, 29999})
    void 총혜택금액이_20000이상이면_산타을_반환(int money){
        // when
        Event event = new Event(money);
        // then
        assertThat(event.toString()).isEqualTo("산타");
    }

}