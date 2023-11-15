package christmas.domain.discounts;

import static christmas.constants.StringConstants.WON_FORMAT;

public class BenefitDiscount implements Discount {
    private static final int BENEIFT_DISCOUNT = 25000;

    private final boolean isGift;

    public BenefitDiscount(final boolean isGift) {
        this.isGift = isGift;
    }

    public static BenefitDiscount from(final boolean gift) {
        if (gift) {
            return new BenefitDiscount(gift);
        }
        return null;
    }

    @Override
    public int reqeustDiscountAmount() {
        return BENEIFT_DISCOUNT;
    }

    @Override
    public String getDiscountString() {
        return "증정 이벤트: -" + WON_FORMAT.format(BENEIFT_DISCOUNT);
    }
}
