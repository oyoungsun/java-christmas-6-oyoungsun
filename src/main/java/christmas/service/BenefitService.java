package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.PayAmount;

public class BenefitService {

    private static final int MINMUM_ORDER_PRICE = 12000;
    private final PayAmount payAmount;
    private final Benefit benefit;

    private BenefitService(final PayAmount payAmount) {
        this.payAmount = payAmount;
        boolean isGift = isGiftNeeded(payAmount);
        this.benefit = Benefit.from(isGift);
    }

    public static BenefitService from(final PayAmount payAmount){
        return new BenefitService(payAmount);
    }

    private boolean isGiftNeeded(final PayAmount payAmount) {
        if (payAmount.isMoreThan(MINMUM_ORDER_PRICE)) return true;
        return false;
    }

    public Benefit getBenefit() {
        return benefit;
    }
}
