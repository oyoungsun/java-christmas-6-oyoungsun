package christmas.utils.exception;

import christmas.view.OutputView;
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

    private static void printExceptionMessage(final IllegalArgumentException e) {
        OutputView.printExceptionMessage(String.format("%s %s", ERROR_PREFIX, e.getMessage()));
    }
}

