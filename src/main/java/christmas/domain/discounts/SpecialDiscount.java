package christmas.domain.discounts;

import static christmas.constants.StringConstants.WON_FORMAT;

import christmas.domain.Date;

public class SpecialDiscount implements Discount {

    private static final int SPECIAL_DISCOUNT = 1000;
    private final Date date;

    public SpecialDiscount(final Date date) {
        this.date = date;
    }

    public static SpecialDiscount from(final Date date) {
        if(date.isSpecial()) {
            return new SpecialDiscount(date);
        }
        return null;
    }

    @Override
    public int reqeustDiscountAmount() {
        return SPECIAL_DISCOUNT;
    }

    @Override
    public String toString() {
        return "특별 할인: -" + WON_FORMAT.format(SPECIAL_DISCOUNT);
    }

}

