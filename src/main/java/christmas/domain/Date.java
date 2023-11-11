package christmas.domain;

import christmas.utils.validators.DateValidator;

public class Date {
    private static final int year = 2023;
    private static final int month = 12;

    private int day;

    private Date(final int day){
        this.day = day;
    }

    public static Date from(final int day, final DateValidator dateValidator){
        dateValidator.validate(day);
        return new Date(day);
    }
}
