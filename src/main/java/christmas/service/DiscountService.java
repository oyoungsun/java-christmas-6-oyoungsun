package christmas.service;

import christmas.domain.Date;
import christmas.domain.PayAmount;

public class DiscountService {
    private static final int MINIMUM_EVENT_PRICE = 10000;
    private final PayAmount payAmount;
    private final Date date;

    private DiscountService(final PayAmount payAmount, final Date date){
        this.payAmount = payAmount;
        this.date = date;
    }

    public static DiscountService from(final PayAmount payAmount, final Date date){
        if(payAmount.isMoreThan(MINIMUM_EVENT_PRICE)){
            return new DiscountService(payAmount, date);
        }
        return null;
    }

}
