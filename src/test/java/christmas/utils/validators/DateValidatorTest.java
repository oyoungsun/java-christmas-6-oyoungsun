package christmas.utils.validators;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateValidatorTest {

    private final DateValidator dateValidator = new DateValidator();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 정수_날짜를주면_검증을_통과한다(int day) {
        assertDoesNotThrow(() -> dateValidator.validate(day));
    }

    @ParameterizedTest
    @ValueSource(ints = {32, 0, -1, 35})
    void 달력숫자외의_숫자를주면_예외를_반환한다(int day) {
        assertThatThrownBy(() -> dateValidator.validate(day)).isInstanceOf(IllegalArgumentException.class);
    }
}