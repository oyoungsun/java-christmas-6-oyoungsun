package christmas.domain.discounts;

import static christmas.constants.StringConstants.WON_FORMAT;

import christmas.domain.Date;

public class ChristmasDiscount implements Discount {

    private static final int CHRISTMAS = 25;
    private static final int INITIAL_DISCOUNT = 1000;
    private static final int DAY_DISCOUNT = 100;
    private static final int FIRST_DAY = 1;
    private final Date date;

    private ChristmasDiscount(final Date date) {
        this.date = date;
    }

    public static ChristmasDiscount from(final Date date) {
        if (date.isBefore(CHRISTMAS)) {
            return new ChristmasDiscount(date);
        }
        return null;
    }

    @Override
    public String getDiscountString() {
        return "크리스마스 디데이 할인: -" + WON_FORMAT.format(INITIAL_DISCOUNT + (long) (date.getDifferent(FIRST_DAY)) * DAY_DISCOUNT);
    }

    @Override
    public int reqeustDiscountAmount() {
        return INITIAL_DISCOUNT + (date.getDifferent(FIRST_DAY)) * DAY_DISCOUNT;
    }


}
