package christmas.utils.validators;

public class InputValidator {
    public static final String NULL_INPUT_EXCEPTION = "사용자의 입력이 null 입니다.";
    public static final String EMPTY_INPUT_EXCEPTION = "사용자의 입력이 비어있습니다.";

    public String validate(final String input) {
        if (IsNull(input)) {
            throw new NullPointerException(NULL_INPUT_EXCEPTION);
        }
        if (IsEmptyString(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
        if (isBlankString(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
        return input;
    }

    private boolean IsEmptyString(final String input) {
        return input.isEmpty();
    }

    private boolean IsNull(final String input) {
        return input == null;
    }

    private boolean isBlankString(final String input) {
        return input.isBlank();
    }

}
