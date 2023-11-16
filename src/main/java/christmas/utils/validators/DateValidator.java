package christmas.utils.validators;

public class DateValidator {
    private static final int FIRST_DAY = 1;
    private static final int LAST_DAY = 31;

    public void validate(final int day) {
        if (!IsInDecemberDay(day)) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private boolean IsInDecemberDay(final int day) {
        return FIRST_DAY <= day && day <= LAST_DAY;
    }
}
