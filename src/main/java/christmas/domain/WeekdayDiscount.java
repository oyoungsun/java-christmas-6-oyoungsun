package christmas.domain;

public class WeekdayDiscount implements Discount{

    private static final int WEEKDAY_DISCOUNT = 2023;
    private final Date date;
    private final int dessertCount;

    private WeekdayDiscount(final Date date, final int dessertCount){
        this.date = date;
        this.dessertCount = dessertCount;
    }

    public static WeekdayDiscount from(final Date date, final int dessertCount) {
        if(!date.isWeekend()){
            return new WeekdayDiscount(date, dessertCount);
        }
        return null;
    }

    @Override
    public int reqeustDiscountAmount() {
        return dessertCount * WEEKDAY_DISCOUNT;
    }
}

