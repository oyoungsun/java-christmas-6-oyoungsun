package christmas.domain;

public class BenefitDiscount implements Discount {
    private static final int BENEIFT_DISCOUNT = 25000;

    private final boolean isGift;

    public BenefitDiscount(final boolean isGift) {
        this.isGift = isGift;
    }

    public static BenefitDiscount from(final boolean gift) {
        if(gift) {
            return new BenefitDiscount(gift);
        }
        return null;
    }

    @Override
    public int reqeustDiscountAmount() {
        return BENEIFT_DISCOUNT;
    }
}
