package christmas.domain;

import christmas.utils.validators.DateValidator;

public class Date {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int FIRST_FRIDAY = 1;
    private static final int FIRST_SATURDAY = 2;

    private int day;

    private Date(final int day){
        this.day = day;
    }

    public static Date from(final int day, final DateValidator dateValidator){
        dateValidator.validate(day);
        return new Date(day);
    }

    public boolean isWeekend(){
        if(day % 7 == FIRST_FRIDAY) return true;
        if(day % 7 == FIRST_SATURDAY) return true;
        return false;
    }

}
