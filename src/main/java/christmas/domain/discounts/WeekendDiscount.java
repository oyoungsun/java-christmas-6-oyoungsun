package christmas.domain.discounts;

import static christmas.constants.StringConstants.WON_FORMAT;

import christmas.domain.Date;

public class WeekendDiscount implements Discount {

    private static final int WEEKEND_DISCOUNT = 2023;
    private final Date date;
    private final int mainCount;

    private WeekendDiscount(final Date date, final int mainCount) {
        this.date = date;
        this.mainCount = mainCount;
    }

    public static WeekendDiscount from(final Date date, final int mainCount) {
        if (date.isWeekend()) {
            return new WeekendDiscount(date, mainCount);
        }
        return null;
    }

    @Override
    public int reqeustDiscountAmount() {
        return mainCount * WEEKEND_DISCOUNT;
    }

    @Override
    public String toString() {
        return "주말 할인: -" + WON_FORMAT.format(mainCount * WEEKEND_DISCOUNT);
    }
}
