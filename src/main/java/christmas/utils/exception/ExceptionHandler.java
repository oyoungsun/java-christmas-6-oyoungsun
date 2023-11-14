package christmas.utils.exception;

import christmas.domain.Date;
import christmas.view.OutputView;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {
    private static final String ERROR_PREFIX = "[ERROR]";

    public static <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return input(supplier);
        }
    }

    public static <T, U, R> R convert(BiFunction<T, U, R> function, T inputString, U validator) {
        try {
            return function.apply(inputString, validator);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return convert(function, inputString, validator);
        }
    }

    private static void printExceptionMessage(final IllegalArgumentException e) {
        OutputView.printExceptionMessage(String.format("%s %s", ERROR_PREFIX, e.getMessage()));
    }

}

