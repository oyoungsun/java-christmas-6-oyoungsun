package christmas.utils.validators;

public class InputValidator {
    public static final String NULL_INPUT_EXCEPTION = "사용자의 입력이 null 입니다.";
    public static final String EMPTY_INPUT_EXCEPTION = "사용자의 입력이 비어있습니다.";

    public String validate(final String input) {
        if (isNull(input)) {
            throw new NullPointerException(NULL_INPUT_EXCEPTION);
        }
        if (isEmptyString(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
        if (isBlankString(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
        return input;
    }

    private boolean isEmptyString(final String input) {
        return input.isEmpty();
    }

    private boolean isNull(final String input) {
        return input == null;
    }

    private boolean isBlankString(final String input) {
        return input.isBlank();
    }

}
