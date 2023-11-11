package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.utils.validators.DateValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class DateTest {
    private DateValidator dateValidator = new DateValidator();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 정수_날짜를주면_Date객체를_생성한다(int day) {
        Date result = Date.from(day, dateValidator);
        assertThat(result).isInstanceOf(Date.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {32, 0, -1, 35})
    void 달력숫자외의_숫자를주면_예외를_반환한다(int day) {
        assertThatThrownBy(() -> Date.from(day, dateValidator)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, false", "9, true", "31, false"})
    void 정수_날짜를주면_주말인지_판단한다(int day, boolean expected) {
        Date date = Date.from(day, dateValidator);
        boolean result = date.isWeekend();
        assertThat(result).isEqualTo(expected);
    }

}