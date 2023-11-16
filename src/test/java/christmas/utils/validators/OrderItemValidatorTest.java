package christmas.utils.validators;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OrderItemValidatorTest {
    private final OrderItemValidator validator = new OrderItemValidator();

    @ParameterizedTest
    @CsvSource(value = {"'초코케이크', 1", "'레드와인', 3", "'해산물파스타', 2"})
    void 메뉴이름_개수를주면_검증을_통과한다(String name, int count) {
        assertDoesNotThrow(() -> validator.validate(name, count));
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크1", "해산물2파스타", ","})
    void 없는메뉴의_이름을_주면_예외를_반환한다(String wrongName) {
        assertThatThrownBy(() -> validator.validate(wrongName, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 21})
    void 메뉴의_최대최소_주문수량을_주면_예외를_반환한다(int count) {
        assertThatThrownBy(() -> validator.validate("초코케이크", count)).isInstanceOf(IllegalArgumentException.class);
    }

}