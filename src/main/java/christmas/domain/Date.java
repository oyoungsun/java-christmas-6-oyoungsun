package christmas.domain;

import christmas.utils.validators.DateValidator;
import java.util.Set;

public class Date {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int FIRST_FRIDAY = 1;
    private static final int FIRST_SATURDAY = 2;
    private static final Set<Integer> spcial = Set.of(3, 10, 17, 24, 25, 31);
    private final int day;

    private Date(final int day) {
        this.day = day;
    }

    public static Date from(final int day, final DateValidator dateValidator) {
        dateValidator.validate(day);
        return new Date(day);
    }

    public boolean isWeekend() {
        if (day % 7 == FIRST_FRIDAY) {
            return true;
        }
        return day % 7 == FIRST_SATURDAY;
    }

    public boolean isBefore(int other) {
        return day <= other;
    }

    public int getDifferent(final int other) {
        return this.day - other;
    }

    public boolean isSpecial() {
        return spcial.contains(day);
    }
}
