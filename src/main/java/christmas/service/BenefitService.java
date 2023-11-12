package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.PayAmount;

public class BenefitService {

    private static final int MINMUM_ORDER_PRICE = 12000;
    private final PayAmount payAmount;
    private final Benefit benefit;

    public BenefitService(final PayAmount payAmount) {
        this.payAmount = payAmount;
        boolean isGift = isGiftNeeded(payAmount);
        this.benefit = Benefit.from(isGift);
    }

    private boolean isGiftNeeded(final PayAmount payAmount) {
        if (payAmount.isMoreThan(MINMUM_ORDER_PRICE)) return true;
        return false;
    }

}
